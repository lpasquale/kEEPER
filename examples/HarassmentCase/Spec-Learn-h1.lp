time(0..0).

next(0,1).
% Domain properties

% academic
acad(lily).

% student
stud(amy).

% email address
addr(alily;aamy).
faddr(nobodyAtNitrobaDotOrg).

sendAddr(alily;aamy).
recAddr(alily;aamy).


% email body
email(e1).

% teaching course
course(chemistry).

%location
loc(uni;res).

% routers
rout(r1;r2).

%ip addresses
ip(ip1;ip2).
sendIp(ip1;ip2).
recIp(ip1;ip2).

browser(b1).



%;******** Fluent definitions*********


% A student attends a course
fluent(attend(P,C)):-
stud(P), course(C).

% An academic teaches a course
fluent(teach(P,C)):-
acad(P), course(C).

%A student owns an email address
fluent(studEmail(S,E)):-
stud(S),addr(E).

%An academic owns an email address
fluent(acadEmail(A,E)):-
acad(A),addr(E).

% A router is located in a specific place
fluent(isLocatedIn(R,L)):-
rout(R), loc(L).

% A student has access to a location
fluent(hasBadgeS(S,L)):-
stud(S), loc(L).

% An academic has access to a location
fluent(hasBadgeA(A,L)):-
acad(A), loc(L).


% A cookie is set between user having email address E and server A
fluent(cookieSet(E,S,D)):-
addr(E), sendIp(S), recIp(D).

fluent(anonHarassEmailSent(E,P1)):-
email(E), stud(P1).

%;********Primitive events*********

event(V):-
pe(V).

%A harassing mail is sent from S to D through router R
pe(send_email(E,S,D,A,R)):-
email(E), sendAddr(S), recAddr(D), ip(A), rout(R).

pe(send_fake_email(E,S,D,A,R)):-
email(E), faddr(S), addr(D), ip(A), rout(R).

%A cookie whose id contains email address S  is set from server A to user B
pe(set_cookie(S,A,B,R)):-
addr(S),
sendIp(A),
recIp(B),
rout(R).


%Messages are exchanged from address A to B
%% by using a cookie associated with email address S

pe(exchange_msg(B,S,D,R)):-
browser(B), sendIp(S), recIp(D), rout(R).

pe(send_anon_email(B,S,D,R)):-
browser(B), sendIp(S), recIp(D), rout(R).


%;******** Complex events *********

event(V):-
ce(V).

ce(emailSent(E,S,R,W)):-
email(E), sendAddr(S), recAddr(R), rout(W).

ce(harassEmailSent(E,P1,P2)):-
email(E), stud(P1), acad(P2).

ce(fakeHarassEmailSent(E,S,P)):-
email(E), faddr(S), acad(P).

ce(initCookie(E,S,D)):-
addr(E), sendIp(S), recIp(D).

ce(acadSendMsg(P,B,S)):-
acad(P), browser(B), sendIp(S).

ce(studSendMsg(P,B,S)):-
stud(P), browser(B), sendIp(S).

ce(sendAnonHarassEmail(E,P1)):-
email(E), stud(P1).

ce(sendAnonHarassEmail(E,S)):-
email(E), sendIp(S).


%;******** Initiated/terminated fluents *********

initiates(initCookie(E,S,D),cookieSet(E,S,D), T):-
addr(E), sendIp(S), recIp(D), time(T).

initiates(sendAnonHarassEmail(E, P1), anonHarassEmailSent(E, P1), T):-
email(E), stud(P1),  time(T).


%;******** Initial State *********


initially(teach(lily,chemistry)).
initially(attend(amy,chemistry)).

initially(studEmail(amy,aamy)).


initially(acadEmail(lily,alily)).

initially(isLocatedIn(r1,uni)).
initially(isLocatedIn(r2,res)).

initially(hasBadgeS(amy,uni)).
initially(hasBadgeS(amy,res)).

initially(hasBadgeA(lily,uni)).

% ******** Behaviour models ********

%These additional rules specify how data coming from the monitor can be combined
%with the existing knowledge to generate additional events that can initiate/terminate the aforementioned fluents


happens(sendAnonHarassEmail(E,S), T, TR):-
email(E),
trace(TR),
sendIp(S),
time(T),
time(T1),
T1 < T,
browser(B),
sendIp(S),
rout(R),
recIp(D),
acad(P2),
stud(P1),
not happens(acadSendMsg(P2,B,S),T1,TR),
not happens(studSendMsg(P1,B,S),T1,TR),
happens(send_anon_email(B,S,D,R),T,TR).

happens(sendAnonHarassEmail(E,P1), T,TR):-
trace(TR),
email(E),
stud(P1),
time(T),
time(T1),
T1 < T,
browser(B),
sendIp(S),
rout(R),
recIp(D),
happens(studSendMsg(P1,B,S),T1,TR),
happens(send_anon_email(B,S,D,R),T,TR).

happens(acadSendMsg(P,B,S),T,TR):-
browser(B),
sendIp(S),
recIp(S),
recIp(D),
sendIp(D),
rout(R),
time(T),
acad(P),
loc(L1),
addr(E),
trace(TR),
happens(exchange_msg(B,S,D,R),T,TR),
holdsAt(cookieSet(E,D,S),T,TR),
holdsAt(hasBadgeA(P,L1),T,TR),
holdsAt(isLocatedIn(R,L1),T,TR),
holdsAt(acadEmail(P,E),T,TR).

happens(studSendMsg(P,B,S),T,TR):-
trace(TR),
browser(B),
sendIp(S),
recIp(S),
recIp(D),
sendIp(D),
rout(R),
time(T),
stud(P),
loc(L1),
addr(E),
holdsAt(studEmail(P,E),T,TR),
happens(exchange_msg(B,S,D,R),T,TR),
holdsAt(hasBadgeS(P,L1),T,TR),
holdsAt(isLocatedIn(R,L1),T,TR),
holdsAt(cookieSet(E,D,S),T,TR).


%A cookie is initiated if a set cookie message is exchanged between the
%server and the receiver
happens(initCookie(E,S,D), T,TR):-
trace(TR),
addr(E),
time(T),
rout(R),
sendIp(S), recIp(D),
S != D,
happens(set_cookie(E,S,D,R),T,TR),
not holdsAt(cookieSet(E,S,D),T,TR).

% A harassing email is sent through router R
happens(emailSent(E,S,R,W),T,TR) :-
trace(TR),
time(T),
sendAddr(S), recAddr(R),
email(E),
rout(W),
ip(A),
happens(send_email(E,S,R, A,W),T,TR).






% A harassing email is sent to a teacher by one of his/her students
happens(harassEmailSent(E,P1,P2),T,TR) :-
trace(TR),
time(T),
sendAddr(S), recAddr(R),
email(E),
stud(P1),
acad(P2),
rout(W),
course(C),
holdsAt(studEmail(P1,S),T,TR),
holdsAt(acadEmail(P2,R), T,TR),
happens(emailSent(E,S,R,W),T,TR),
holdsAt(hasBadgeS(P1,L1),T,TR),
holdsAt(isLocatedIn(W,L1),T,TR),
holdsAt(teach(P2,C),T,TR),
holdsAt(attend(P1,C),T,TR).

% A harassing email is sent to a teacher by using a fake address
happens(fakeHarassEmailSent(E,S,P),T,TR) :-
trace(TR),
time(T),
faddr(S),
addr(R),
email(E),
acad(P),
holdsAt(acadEmail(P,R),T,TR),
ip(A),
rout(W),
happens(send_fake_email(E,S,R,A,W),T,TR).


holdsAt(studEmail(P1,S),T,TR) :-
stud(P1),
addr(S),
time(T),
trace(TR),
not holdsAt(acadEmail(P2,S),T,TR),
acad(P2).

holdsAt(acadEmail(P1,S),T,TR) :-
acad(P1),
addr(S),
time(T),
trace(TR),
not holdsAt(studEmail(P2,S),T,TR),
stud(P2).



hyp(h1).

hypothesis(h1,T,TR):-
trace(TR),
time(T),
email(E),
faddr(S),
acad(P),
happens(fakeHarassEmailSent(E,S,P),T,TR).




hypothesis(h1,TR):-
	trace(TR),
	time(T),
	hypothesis(h1,T,TR).

% ----- * Satisfaction Argument E /\ H is  consistent * -----

:- trace(TR), pos(TR), not hypothesis(h1,TR).

% ----- * Satisfaction Argument E /\ !H is consistent (if needed)*  -----

:- trace(TR), neg(TR), hypothesis(h1,TR).

%-------% --*** Domain-independent Axioms ***---

clipped(T1, F, T2,TR):-
trace(TR),
time(T1),
time(T2),
fluent(F),
time(T),
T1<=T,
T<T2,
event(E),
happens(E, T,TR),
terminates(E, F, T).

declipped(T1, F, T2,TR):-
trace(TR),
time(T1),
time(T2),
fluent(F),
time(T),
T1<=T,
T<T2,
event(E),
happens(E, T,TR),
initiates(E, F, T).


holdsAt(F, T2,TR):-
trace(TR),
time(T2),
fluent(F),
time(T1),
T1<T2,
event(E),
happens(E, T1,TR),
initiates(E, F, T1),
not clipped(T1, F, T2,TR).

holdsAt(F, T2,TR):-
trace(TR),
fluent(F),
time(T2),
initially(F),
not clipped(0, F, T2,TR).

neg_holdsAt(F, T,TR):-
trace(TR),
fluent(F),
time(T),
not holdsAt(F, T,TR).

holdsAt_between(T1, F,T2,TR):-
trace(TR),
time(T2),
fluent(F),
time(T1),
T1<T2,
holdsAt(F, T1,TR),
holdsAt(F, T2,TR),
not clipped(T1, F, T2,TR).

neg_holdsAt_between(T1, F,  T2,TR):-
trace(TR),
time(T2),
fluent(F),
time(T1),
T1<T2,
neg_holdsAt(F, T1,TR),
neg_holdsAt(F, T2,TR),
not declipped(T1, F, T2,TR).

pr_happens(A,T,TR):-
    trace(TR),
    time(T),
    pe(A),
    happens(A,T,TR).

co_happens(A,T,TR):-
    trace(TR),
    time(T),
    ce(A),
    happens(A,T,TR).



%-------
trace(tr4;tr3;tr1;tr2).
pos(tr4;tr3;tr1;tr2).

happens(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip1,r1),0,tr1).
happens(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip1,r2),0,tr2).
happens(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip2,r1),0,tr3).
happens(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip2,r2),0,tr4).


% ----- * Heuristics for Minimal Histories * -----

nothing_happens_between(T1, T2,TR):-
trace(TR),
time(T2),
time(T1),
time(T),
T1<T,
T<T2,
not anything_happens(T,TR).

anything_happens(T,TR):-
trace(TR),
pe(A),
time(T),
happens(A,T,TR).


:- time(T1), time(T2), pe(A1), pe(A2), trace(TR),
happens(A1,T1,TR), happens(A2,T2,TR),
nothing_happens_between(T1,T2,TR).


clock(0..1).

event(V):-
    op(V).

fluent(F):-
    fop(F).

% Spec

op(preserve(A,TS)):-
    clock(TS),
    pe(A).

fop(preserved(A,TS)):-
    clock(TS),
    pe(A).

initiates(preserve(A,TS), preserved(A,TS), T):-
    pe(A),
    clock(TS),
    time(T),
    op(preserve(A,TS)),
    fop(preserved(A,TS)).

dpre(preserve(A,TS), T, TR):-
    trace(TR),
    time(T),
    clock(TS),
    pe(A),
    not holdsAt(preserved(A,TS),T,TR).

rpre(preserve(A,TS), T, TR):-
    trace(TR),
    time(T),
    clock(TS),
    pe(A),
    happens(receive(A,TS),T,TR).

op(receive(A,TS)):-
    clock(TS),
    pe(A).

fop(received(A,TS)):-
    clock(TS),
    pe(A).

initiates(receive(A,TS), received(A,TS), T):-
    pe(A),
    time(T),
    clock(TS),
    op(receive(A,TS)),
    fop(received(A,TS)).

dpre(receive(A,TS), T,TR):-
    trace(TR),
    time(T),
    clock(TS),
    pe(A),
    not holdsAt(received(A,TS),T,TR).

happens(A,T,TR):-
    trace(TR),
    time(T),
    op(A),
    rtrig(A,T,TR),
    dpre(A,T,TR).

:- pe(A), time(T),trace(TR), clock(TS),
    happens(preserve(A,TS),T,TR),
    not dpre(preserve(A,TS),T,TR).

:- pe(A), time(T),trace(TR), clock(TS), pos(TR),
    happens(preserve(A,TS),T,TR),
    not rpre(preserve(A,TS),T,TR).

:- pe(A), time(T),trace(TR), clock(TS), pos(TR),
    rtrig(preserve(A,TS),T,TR),
    dpre(preserve(A,TS),T,TR),
    not rpre(preserve(A,TS),T,TR).

happens(receive(A,T),T,TR):-
    time(T),
    trace(TR),
    pe(A),
    happens(A,T,TR).

happens_pred(preserve(A,TS), T, TR):-
    time(T),
    trace(TR),
    clock(TS),
    pe(A),
    time(T0),
    next(T0,T),
    clock(TS0),
    next(TS0,TS),
    happens(preserve(A,TS0), T0, TR).

not_happens_pred(preserve(A,TS), T, TR):-
    time(T),
    trace(TR),
    clock(TS),
    pe(A),
    time(T0),
    next(T0,T),
    clock(TS0),
    TS0<TS,
    not happens(preserve(A,TS0), T0, TR).

happens_prev(preserve(A,TS), T, TR):-
    time(T),
    trace(TR),
    clock(TS),
    pe(A),
    time(T0),
    T0<T,
    clock(TS0),
    TS0<TS,
    happens(preserve(A,TS0), T0, TR).

not_happens_prev(preserve(A,TS), T, TR):-
    time(T),
    trace(TR),
    clock(TS),
    op(A),
    time(T0),
    T0<T,
    not happens_prev(preserve(A,TS), T0, TR).
%-------




% ----- * Forensic Readiness Requirements * -----

:- pe(A), time(T), trace(TR),happens(A,T,TR), pos(TR),
    not happens(preserve(A,T), T,TR).

:- pe(A), trace(TR), time(T),happens(preserve(A,T),T,TR),
    not happens(A, T,TR).

:- pe(A), trace(TR), clock(TS),
    neg(TR),
    not at_least_one_nrtrig(TR).

nrtrig(preserve(A,TS),T,TR):-
    pe(A), time(T),trace(TR), clock(TS),
    happens(receive(A,TS),T,TR),
    not rtrig(preserve(A,TS),T,TR).

at_least_one_nrtrig(TR):-
    pe(A), time(T),trace(TR), clock(TS),
    nrtrig(preserve(A,TS),T,TR).


op_happens(A,T,TR):-
    trace(TR),
    time(T),
    op(A),
    happens(A,T,TR).



example(ex1;ex2;ex3;ex4).

ex1:-
	op_happens(preserve(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip2,r2),0),0,tr4).

ex2:-
	op_happens(preserve(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip2,r1),0),0,tr3).

ex3:-
	op_happens(preserve(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip1,r1),0),0,tr1).

ex4:-
	op_happens(preserve(send_fake_email(e1,nobodyAtNitrobaDotOrg,alily,ip1,r2),0),0,tr2).

#example ex1.
#example ex2.
#example ex3.
#example ex4.


% ----- * Specification Language * -----

#modeh rtrig(preserve(send_fake_email(+email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).

#modeb happens(receive(send_fake_email(+email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).


#modeb happens_pred(preserve(send_fake_email(-email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(-email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_pred(preserve(send_fake_email(+email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).


#modeb happens_prev(preserve(send_fake_email(-email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(-email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb happens_prev(preserve(send_fake_email(+email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).


#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(-email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,-faddr,+addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,-addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,-addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,-addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,-addr,+ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,+addr,-ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,+addr,-ip,+rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,+addr,+ip,-rout),+clock), +time, +trace).
#modeb not_happens_pred(preserve(send_fake_email(+email,+faddr,+addr,+ip,+rout),+clock), +time, +trace).


