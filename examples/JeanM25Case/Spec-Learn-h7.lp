time(0..2).

next(0,1).
next(1,2).
next(2,3).
% Domain properties

%Jean's computer
comp(m1;m2).

%employees in the example
%emp(alison;jean;bob;carole;david;emmy;gina;harris;indy).
emp(alison;jean;bob).

url(url1;url2).
browser(b1;b2).

%employees' emails
%addr(aalison;ajean;abob;acarole;adavid;aemmy;agina;aharris;aindy).
addr(aalison;ajean).
sendAddr(aalison;ajean).
recAddr(aalison;ajean).

extAddr(abob;atuck).

sendExtAddr(abob;atuck).
recExtAddr(abob;atuck).


% email body
email(e1).

%employees' roles
%role(president;cfo;programmer;marketing;bizdev).
role(president;cfo).

%passwords for employees electronic identities
pwd(pwdJean;pwdAlison).

%confidential file
fi(m57plan).

%storage
st(usb1).

app(app1;app2).

trace(tr1).


next(0,1).


% ++ Context Relations ++

% An employee is logged on a machine

fluent(logged(E,C)):-
    emp(E), comp(C).

%A employee has the permission to log to a machine

fluent(hasPermission(E,C)):-
    emp(E), comp(C).


%A file is stored on a machine

fluent(isStoredIn(F,C)):-
    fi(F), comp(C).

%An employee has an email address
fluent(hasEmail(P,E)):-
    emp(P), addr(E).

%An employee has an email address
fluent(hasEmail(P,E)):-
    emp(P), sendAddr(E).

%An employee has an email address
fluent(hasEmail(P,E)):-
    emp(P), recAddr(E).

%An employee has a password associated with his/her email address
fluent(hasPwd(E,P)):-
    emp(E), pwd(P).

%An employee has a role
fluent(hasRole(E,R)):-
    emp(E), role(R).

%A storage device is mounted on a computer
fluent(mounted(S,C)):-
    st(S), comp(C).

% An employee owns a storage device
fluent(possess(E,S)):-
    emp(E), st(S).

% A storage device was mounted once
fluent(mountedOnce(S,C)):-
    st(S),comp(C).

% A storage device was mounted twice
fluent(mountedTwice(S,C)):-
    st(S),comp(C).

% An application is blacklisted
fluent(isMalware(A)):-
    app(A).

% An application is blacklisted
fluent(isBlacklisted(U)):-
    url(U).

% An application is installed on a computer
fluent(installed(A,C)):-
    app(A), comp(C).

% An application is installed on a computer
fluent(isInstalled(B,C)):-
    browser(B), comp(C).


% +++ Behaviour Description +++

%;******** Primitive events *********

event(V):-
    pe(V).

%An email with an attachment is sent by an employee to
% another employee
pe(send_email_e2e(E,A,S,R,C)):-
    email(E), fi(A), sendAddr(S), recAddr(R), comp(C).

%An email with an attachment is sent by an employee to
% an external email address
pe(send_email_e2ext(E,A,S,R,C)):-
    email(E), fi(A), addr(S), extAddr(R), comp(C).

%An email with an attachment is sent from an external address to
% an employee
pe(send_email_ext2e(E,A,S,R,C)):-
    email(E), fi(A), extAddr(S), addr(R), comp(C).

%An email with an attachment is sent from an external address to
% an external address
pe(send_email_ext2ext(E,A,S,R,C)):-
    email(E), fi(A), sendExtAddr(S), recExtAddr(R), comp(C).

%An email with a request to send the document is received by
%an internal email account from an internal email address
pe(rec_email_req_e2e(E,D,S,R,C)):-
    email(E), fi(D), sendAddr(S), recAddr(R), comp(C).

%An email with a request to send the document is received by
%an external email account from an internal email address
pe(rec_email_req_e2ext(E,D,S,R,C)):-
    email(E), fi(D), addr(S), extAddr(R), comp(C).

%An email with a request to send the document is received by
%an internal email account from an external email address
pe(rec_email_req_ext2e(E,D,S,R,C)):-
    email(E), fi(D), extAddr(S), addr(R), comp(C).

%An email with a request to send the document is received by
%an external email account from an external email address
pe(rec_email_req_ext2ext(E,D,S,R,C)):-
    email(E), fi(D), sendExtAddr(S), recExtAddr(R), comp(C).


%% login is performed by an employee to a computer
pe(sys_login(E,P, C)):-
    emp(E), pwd(P), comp(C).

%% logout is performed by an employee to a computer
pe(sys_logout(E, C)):-
    emp(E), comp(C).


%% a storage device is mounted on a computer
pe(sys_mount(S,C)):-
    st(S), comp(C).

%% a storage device is unmounted on a computer
pe(sys_unmount(S,C)):-
    st(S), comp(C).

%% a document is copied on a computer
pe(sys_copy(E, F, C)):-
    emp(E), fi(F), comp(C).


pe(sys_install(A,C)):-
    app(A), comp(C).

pe(sys_uninstall(A,C)):-
    app(A), comp(C).

pe(web_connection(B,U,C)):-
    browser(B), url(U), comp(C).



% Complex events

event(V):-
    ce(V).


%An email is Sent by an employee To an employee
ce(emailSentE2E(E,A,P1,P2)):-
    email(E), fi(A), emp(P1), emp(P2).

%An email is Sent by an employee To an external address
ce(emailSentE2Ext(E,A,P,R)):-
    email(E), fi(A), emp(P), extAddr(R).

%An email is Sent by an employee To an external address
ce(emailSentExt2ExtS(E,A,P,R)):-
    email(E), fi(A), emp(P), extAddr(R).

%An email is Sent by an employee To an external address
ce(emailSentExt2ExtD(E,A,P,R)):-
    email(E), fi(A), emp(P), extAddr(R).

%An email is received by an employee from another employee
ce(recEmailReqE2E(E,D,P1,P2)):-
    email(E), fi(D), emp(P1), emp(P2).

%An email is received by an employee from an external address
ce(recEmailReqExt2E(E,D,S,P)):-
    email(E), fi(D), extAddr(S), emp(P).


%An email previously received is answered by an employee
%including an attachment
ce(answerEmailE2E(E1,E2,A,P1,P2)):-
    email(E1), email(E2), fi(A), emp(P1), emp(P2).

%An email previously received from an external address
%is answered by an employee including an attachment
ce(answerEmailE2Ext(E1,E2,A,P,S)):-
    email(E1), email(E2), fi(A), emp(P), extAddr(S).


%An employee logins to a computer
ce(login(E,C)):-
    emp(E), comp(C).

%An employee logouts from a computer
ce(logout(E,C)):-
    emp(E), comp(C).

%A device is mounted on a computer
ce(mount(S,C)):-
    st(S), comp(C).

%A device is unmounted from a computer
ce(unmount(S,C)):-
    st(S), comp(C).

% An employee copies a file on a computer
ce(copy(E,F,C)):-
    emp(E), fi(F), comp(C).

% An employee owns a storage device
ce(own(E,S)):-
    emp(E), st(S).

%A device is mounted once a computer
ce(mountOne(S,C)):-
    st(S), comp(C).

%A device is mounted twice on a computer
ce(mountTwo(S,C)):-
    st(S), comp(C).

ce(install(A,C)):-
    app(A),comp(C).

ce(uninstall(A,C)):-
    app(A),comp(C).

ce(webConnection(B,U,C)):-
    browser(B), url(U), comp(C).

% ++ Basic/Composite Complex Definitions +

happens(login(E,C),T,TR):-
    emp(E),
    comp(C),
    time(T),
    trace(TR),
    emp(E2),
    happens(sys_login(E,P,C),T,TR),
    holdsAt(hasPermission(E,C),T,TR),
    holdsAt(hasPwd(E,P),T,TR).

happens(logout(E,C),T,TR):-
    emp(E),
    comp(C),
    time(T),
    trace(TR),
    happens(sys_logout(E,C),T,TR),
    holdsAt(logged(E,C),T,TR).


%An email with attachment A is sent by an employee
%to an employee by using an internal email account
happens(emailSentE2E(E,A,P1,P2),T,TR):-
    trace(TR),
    email(E),
    fi(A),
    sendAddr(S),
    recAddr(R),
    time(T),
    comp(C),
    emp(P1), emp(P2),
    happens(send_email_e2e(E,A,S,R,C),T,TR),
    holdsAt(hasEmail(P1,S),T,TR),
    holdsAt(logged(P1,C),T,TR),
    holdsAt(hasEmail(P2,R),T,TR).

%An email with attachment A is sent by an employee
%to an employee by using an external email account
happens(emailSentE2E(E,A,P1,P2),T,TR):-
    trace(TR),
    email(E),
    fi(A),
    extAddr(S),
    addr(R),
    time(T),
    comp(C),
    emp(P1), emp(P2),
    happens(send_email_ext2e(E,A,S,R,C),T,TR),
    holdsAt(hasEmail(P2,R),T,TR),
    holdsAt(logged(P1,C),T,TR).


%An email with attachment A is sent to an external email address by an employee
%who is  using his/her internal email account
happens(emailSentE2Ext(E,A,P,R),T,TR):-
    trace(TR),
    email(E),
    fi(A),
    addr(S),
    extAddr(R),
    time(T),
    comp(C),
    emp(P),
    happens(send_email_e2ext(E,A,S,R,C),T,TR),
    holdsAt(hasEmail(P,S),T,TR),
    holdsAt(logged(P,C),T,TR).

%An email with attachment A is sent to an external email address by an employee
%who is  using an external email account
happens(emailSentExt2ExtS(E,A,P,R),T,TR):-
    trace(TR),
    email(E),
    fi(A),
    sendExtAddr(S),
    recExtAddr(R),
    S == R,
    time(T),
    comp(C),
    emp(P),
    happens(send_email_ext2ext(E,A,S,R,C),T,TR),
    holdsAt(logged(P,C),T,TR).

happens(emailSentExt2ExtD(E,A,P,R),T,TR):-
    email(E),
    fi(A),
    sendExtAddr(S),
    recExtAddr(R),
    S != R,
    time(T),
    comp(C),
    emp(P),
    trace(TR),
    happens(send_email_ext2ext(E,A,S,R,C),T,TR),
    holdsAt(logged(P,C),T,TR).


%An email is received by an employee from another employee
happens(recEmailReqE2E(E,D,P1,P2),T,TR):-
    trace(TR),
    email(E),
    fi(D),
    emp(P1),
    emp(P2),
    comp(C),
    time(T),
    sendAddr(S),
    recAddr(R),
    happens(rec_email_req_e2e(E,D,S,R,C),T,TR),
    holdsAt(hasEmail(P2,R),T,TR),
    holdsAt(hasEmail(P1,S),T,TR),
    holdsAt(logged(P2,C),T,TR).

%An email is received by an external account of  employee from another employee
happens(recEmailReqE2E(E,D,P1,P2),T,TR):-
    trace(TR),
    email(E),
    fi(D),
    emp(P1),
    emp(P2),
    comp(C),
    time(T),
    addr(S),
    extAddr(R),
    happens(rec_email_req_e2ext(E,D,S,R,C),T,TR),
    holdsAt(hasEmail(P1,S),T,TR),
    holdsAt(logged(P2,C),T,TR).

%An email is received by an employee from an external email address
happens(recEmailReqExt2E(E,D,S,P),T,TR):-
    trace(TR),
    email(E),
    fi(D),
    emp(P),
    time(T),
    comp(C),
    extAddr(S),
    addr(R),
    happens(rec_email_req_ext2e(E,D,S,R,C),T,TR),
    holdsAt(hasEmail(P,R),T,TR),
    holdsAt(logged(P,C),T,TR).

%%An email is received by an external account of  employee from an external email address
happens(recEmailReqExt2E(E,D,S,P),T,TR):-
    trace(TR),
    email(E),
    fi(D),
    emp(P),
    time(T),
    comp(C),
    sendExtAddr(S),
    recExtAddr(R),
    S != R,
    happens(rec_email_req_ext2ext(E,D,S,R,C),T,TR),
    holdsAt(logged(P,C),T,TR).




happens(answerEmailE2E(E1,E2,A,P1,P2),T2,TR):-
    trace(TR),
    email(E1),
    email(E2),
    P1 != P2,
    fi(A),
    emp(P1),
    emp(P2),
    time(T1),
    time(T2),
    T2 > T1,
    happens(recEmailReqE2E(E1,A,P2,P1),T1,TR),
    happens(emailSentE2E(E2,A,P1,P2),T2,TR).

happens(answerEmailE2Ext(E1,E2,A,P,S),T2,TR):-
    trace(TR),
    email(E1),
    email(E2),
    fi(A),
    emp(P),
    extAddr(S),
    time(T2),
    time(T1),
    T2 > T1,
    happens(emailSentE2Ext(E2,A,P1,S),T2,TR),
    happens(recEmailReqExt2E(E1,A,S,P),T1,TR).


happens(answerEmailE2Ext(E1,E2,A,P,S),T2,TR):-
    trace(TR),
    email(E1),
    email(E2),
    fi(A),
    emp(P),
    extAddr(S),
    time(T2),
    time(T1),
    T2 > T1,
    happens(emailSentExt2ExtD(E2,A,P1,S),T2,TR),
    happens(recEmailReqExt2E(E1,A,S,P),T1,TR).

happens(copy(E,F,C),T,TR):-
    time(T), fi(F), comp(C), emp(E),
    trace(TR),
    happens(sys_copy(E,F,C),T,TR),
    holdsAt(isStoredIn(F,C),T,TR),
    holdsAt(logged(E,C),T,TR).


happens(mount(S,C),T, TR):-
    time(T), comp(C), st(S), emp(E),
    trace(TR),
    happens(sys_mount(S,C),T,TR),
    not holdsAt(mounted(S,C),T,TR),
    holdsAt(logged(E,C),T,TR).

happens(unmount(S,C),T,TR):-
    time(T), comp(C), st(S),
    trace(TR),
    happens(sys_unmount(S,C),T,TR),
    holdsAt(mounted(S,C),T,TR).

happens(mountOne(S,C),T,TR):-
    st(S), comp(C), time(T),
    trace(TR),
    happens(mount(S,C),T,TR),
    not holdsAt(mountedOnce(S,C),T,TR).

happens(mountTwo(S,C),T,TR):-
    st(S), comp(C), time(T),
    trace(TR),
    happens(mount(S,C),T,TR),
    holdsAt(mountedOnce(S,C),T,TR),
    not holdsAt(mountedTwice(S,C),T,TR).


happens(own(P,S),T,TR):-
    time(T),st(S), emp(P), comp(C),
    trace(TR),
    happens(mount(S,C),T,TR),
    holdsAt(mountedTwice(S,C),T,TR),
    holdsAt(hasPermission(P,C),T,TR),
    not holdsAt(possess(P,S),T,TR).


happens(install(A,C),T,TR):-
    app(A),
    comp(C),
    time(T),
    emp(P),
    trace(TR),
    happens(sys_install(A,C),T,TR),
    holdsAt(logged(P,C),T,TR),
    not holdsAt(installed(A,C),T,TR),
    holdsAt(hasPermission(P,C),T,TR).

happens(uninstall(A,C),T,TR):-
    trace(TR),
    app(A),
    comp(C),
    time(T),
    emp(P),
    happens(sys_uninstall(A,C),T,TR),
    holdsAt(logged(P,C),T,TR),
    holdsAt(installed(A,C),T,TR),
    holdsAt(hasPermission(P,C),T,TR).

happens(webConnection(B,U,C),T,TR):-
    trace(TR),
    browser(B),
    url(U),
    comp(C),
    time(T),
    happens(web_connection(B,U,C),T,TR),
    holdsAt(isInstalled(B,C),T,TR),
    holdsAt(logged(E,C),T,TR),
    holdsAt(hasPermission(E,C),T,TR).




%;******* Initiated and Terminated States ********************************

initiates(login(E,C),logged(E,C), T):-
    emp(E), comp(C), time(T).

terminates(logout(E,C),logged(E,C), T):-
    emp(E), comp(C), time(T).

initiates(mount(S,C), mounted(S,C), T):-
    st(S), comp(C), time(T).

initiates(mountOne(S,C), mountedOnce(S,C), T):-
    st(S), comp(C), time(T).

initiates(mountTwo(S,C), mountedTwice(S,C), T):-
    st(S), comp(C), time(T).

terminates(unmount(S,C), mounted(S,C), T):-
    st(S), comp(C), time(T).

initiates(own(P,S), possess(P,S), T):-
    st(S), emp(P), time(T).

initiates(install(A,C), installed(A,C), T):-
    app(A), comp(C), time(T).

terminates(uninstall(A,C), installed(A,C), T):-
    app(A), comp(C), time(T).


%;******** Initial State *********

%Alison and Jean have permission to login to M2 and M1, respectively.

initially(hasPermission(jean,m1)).
initially(hasPermission(alison,m2)).

initially(hasEmail(jean,ajean)).
initially(hasEmail(alison,aalison)).

initially(hasPwd(jean, pwdJean)).
initially(hasPwd(alison, pwdAlison)).

initially(isStoredIn(m57plan,m1)).

initially(isMalware(app1)).

initially(isInstalled(b1,m1)).
initially(isInstalled(b2,m2)).

initially(isBlacklisted(url1)).


% ******************************************************************************hyp(h7).

hypothesis(h7,T,TR):-
    trace(TR),
    time(T),
    st(S),
    comp(C),
    emp(P),
    time(T1),
    holdsAt(mounted(S,C),T,TR),
    happens(copy(P,m57plan,C),T,TR).
    %holdsAt(possess(P,S),T1).
hypothesis(h7,TR):-
	trace(TR),
	time(T),
	hypothesis(h7,T,TR).

% ----- * Satisfaction Argument E /\ H is  consistent * -----

:- trace(TR), pos(TR), not hypothesis(h7,TR).

% ----- * Satisfaction Argument E /\ !H is consistent (if needed)*  -----

:- trace(TR), neg(TR), hypothesis(h7,TR).

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
trace(tr1;tr2;tr3;tr4;tr5).
pos(tr1).

neg(tr2;tr3;tr4;tr5).

happens(sys_copy(jean,m57plan,m1),2,tr1).
happens(sys_mount(usb1,m1),1,tr1).
happens(sys_login(jean,pwdJean,m1),0,tr1).

happens(sys_mount(usb1,m1),1,tr2).

happens(sys_copy(jean,m57plan,m1),2,tr3).

happens(sys_copy(jean,m57plan,m1),2,tr4).
happens(sys_mount(usb1,m1),1,tr4).

happens(sys_copy(jean,m57plan,m1),2,tr5).
happens(sys_login(jean,pwdJean,m1),1,tr5).

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


clock(0..3).

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



example(ex1;ex2;ex3;ex4;ex5).

ex1:-
	op_happens(preserve(sys_copy(jean,m57plan,m1),2),2,tr1),
	op_happens(preserve(sys_mount(usb1,m1),1),1,tr1),
	op_happens(preserve(sys_login(jean,pwdJean,m1),0),0,tr1).

#example ex1.
ex2:-
	op_happens(preserve(sys_mount(usb1,m1),1),1,tr2).

ex3:-
	op_happens(preserve(sys_copy(jean,m57plan,m1),2),2,tr3).

ex4:-
	op_happens(preserve(sys_copy(jean,m57plan,m1),2),2,tr4),
	op_happens(preserve(sys_mount(usb1,m1),1),1,tr4).

ex5:-
	op_happens(preserve(sys_copy(jean,m57plan,m1),2),2,tr5),
	op_happens(preserve(sys_login(jean,pwdJean,m1),1),1,tr5).

#example not ex2.
#example not ex3.
#example not ex4.
#example not ex5.


% ----- * Specification Language * -----

#modeh rtrig(preserve(sys_copy(+emp,+fi,+comp),+clock), +time, +trace).
#modeh rtrig(preserve(sys_mount(+st,+comp),+clock), +time, +trace).
#modeh rtrig(preserve(sys_login(+emp,+pwd,+comp),+clock), +time, +trace).

#modeb happens(receive(sys_copy(+emp,+fi,+comp),+clock), +time, +trace).
#modeb happens(receive(sys_mount(+st,+comp),+clock), +time, +trace).
#modeb happens(receive(sys_login(+emp,+pwd,+comp),+clock), +time, +trace).


#modeb happens_pred(preserve(sys_copy(-emp,-fi,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(-emp,-fi,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(-emp,+fi,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(-emp,+fi,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(+emp,-fi,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(+emp,-fi,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(+emp,+fi,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_copy(+emp,+fi,+comp),+clock), +time, +trace).

#modeb happens_pred(preserve(sys_mount(-st,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_mount(-st,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_mount(+st,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_mount(+st,+comp),+clock), +time, +trace).

#modeb happens_pred(preserve(sys_login(-emp,-pwd,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(-emp,-pwd,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(-emp,+pwd,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(-emp,+pwd,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(+emp,-pwd,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(+emp,-pwd,+comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(+emp,+pwd,-comp),+clock), +time, +trace).
#modeb happens_pred(preserve(sys_login(+emp,+pwd,+comp),+clock), +time, +trace).


#modeb happens_prev(preserve(sys_copy(-emp,-fi,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(-emp,-fi,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(-emp,+fi,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(-emp,+fi,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(+emp,-fi,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(+emp,-fi,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(+emp,+fi,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_copy(+emp,+fi,+comp),+clock), +time, +trace).

#modeb happens_prev(preserve(sys_mount(-st,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_mount(-st,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_mount(+st,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_mount(+st,+comp),+clock), +time, +trace).

#modeb happens_prev(preserve(sys_login(-emp,-pwd,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(-emp,-pwd,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(-emp,+pwd,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(-emp,+pwd,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(+emp,-pwd,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(+emp,-pwd,+comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(+emp,+pwd,-comp),+clock), +time, +trace).
#modeb happens_prev(preserve(sys_login(+emp,+pwd,+comp),+clock), +time, +trace).


#modeb not_happens_pred(preserve(sys_copy(-emp,-fi,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(-emp,-fi,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(-emp,+fi,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(-emp,+fi,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(+emp,-fi,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(+emp,-fi,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(+emp,+fi,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_copy(+emp,+fi,+comp),+clock), +time, +trace).

#modeb not_happens_pred(preserve(sys_mount(-st,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_mount(-st,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_mount(+st,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_mount(+st,+comp),+clock), +time, +trace).

#modeb not_happens_pred(preserve(sys_login(-emp,-pwd,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(-emp,-pwd,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(-emp,+pwd,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(-emp,+pwd,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(+emp,-pwd,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(+emp,-pwd,+comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(+emp,+pwd,-comp),+clock), +time, +trace).
#modeb not_happens_pred(preserve(sys_login(+emp,+pwd,+comp),+clock), +time, +trace).


