time(0..2).

trace(tr1).

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



hyp(h2).

% A harassing email is sent anonymously to a teacher
hypothesis(h2,T,TR):-
    time(T),
    email(E),
    stud(P1),
    trace(TR),
    happens(sendAnonHarassEmail(E,P1),T,TR).




hypothesis(h2,TR):-
	trace(TR),
	time(T),
	hypothesis(h2,T,TR).
:- trace(TR), not hypothesis(h2,TR).

% --*** Domain-independent Axioms ***---

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


#minimize [happens(A,T,TR): pe(A):time(T):trace(TR) @ 1].
0{happens(A,T,TR): pe(A):time(T):trace(TR)}.



#hide.
#show pr_happens/3.

