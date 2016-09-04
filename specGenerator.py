#!/usr/bin/python

import sys
import termios
import os.path
import subprocess
import numpy as np


import time as t
import itertools


e='environment.txt'
d='domain_ind_axioms.txt'
he='heuristics.txt'
t1='tail.txt'
t2='tail2.txt'
s='spec.txt'
sver='spec-ver.txt'
p='pos.txt'
n='neg.txt'
r='req.txt'
relEvents= set()
relPosTraces = set()
relNegTraces = set()
clasp = ''
gringo = ''
xhail = ''

def main():
    try:
        if len(sys.argv) < 2:
            raise InputError("Input Error", "Insufficient number of parameters")
    except InputError as ie:
        print ("Input Error: ", ie.msg)
        sys.exit(0)
    hypNum = sys.argv[2]
    time = sys.argv[1]
    dir = ''
    clingo = ''
    for line in open("conf.txt").readlines():
        if "dir" in line:
            if "\n" in line:
                dir = line[4:line.find("\n")]
            else:
                dir = line[4:]
        if "clingo" in line:
            if "\n" in line:
                clingo = line[7:line.find("\n")]
            else:
                clingo = line[7:]

    histories = history_iden(dir, clingo,time,hypNum)
    if len(histories) < 1:
        print ("hypothesis h"+hypNum+" is not supported in the environment")
    else:
        print ("hypothesis h"+hypNum+" is supported by the following primitive histories")
        pos =  open(dir+"/"+p, 'w')
        for i in range(len(histories)):
            print(histories[i])
            for j in range(len(histories[i])):
                prim_ev = histories[i][j]
                if i == 0:
                    pos.write(prim_ev[3:]+".\n")
                else:
                    pos.write(prim_ev[3:prim_ev.rfind("tr")]+"tr"+str(i +1)+").\n")
        pos.close()
        pres_histories = spec_verification(dir, clingo,time,hypNum)
        if len(pres_histories) > 0:
            print ("The following preservation histories are not covered")
            for i in range(len(pres_histories)):
                print(pres_histories[i])
    
        spec_generation(dir,time,hypNum)
        


#Base class for exceptions in this module.
class Error(Exception):
    pass

class InputError(Error):
    def __init__(self, expr, msg):
        self.msg = msg


def spec_generation(dir,time,hypNum):
    try:
        if not os.path.isfile(dir+"/"+r):
            raise InputError("Input Error","Req file missing")
    except InputError as ie:
        print ("Input Error: ", ie.msg)
        sys.exit(0)

    start = t.time()
    print ("*****************************************")
    print ("   Spec Generation   ")
    print ("*****************************************")
    
    env = open(dir+"/"+e, 'r')
    sg = open(dir+"/Spec-Learn-h"+hypNum+'.lp', 'w')
    sg.write("time(0.."+time+").\n\n")
    
    for i in range(int(int(time)+1)):
        sg.write("next("+str(i)+","+str(int(i)+1)+").\n")
    sg.write(env.read())
    hyp = open(dir+"/"+'h'+hypNum+'.txt', 'r')
    sg.write("hyp(h"+hypNum+").\n\n")
    sg.write(hyp.read())
    sg.write("\nhypothesis(h"+hypNum+",TR):-\n")
    sg.write("\ttrace(TR),\n")
    sg.write("\ttime(T),\n")
    sg.write("\thypothesis(h"+hypNum+",T,TR).\n")
    sg.write("\n% ----- * Satisfaction Argument E /\ H is  consistent * -----\n\n")
    sg.write(":- trace(TR), pos(TR), not hypothesis(h"+hypNum+",TR).\n\n")
    sg.write("% ----- * Satisfaction Argument E /\ !H is consistent (if needed)*  -----\n\n")
    sg.write(":- trace(TR), neg(TR), hypothesis(h"+hypNum+",TR).\n\n")
    sg.write("%-------")
    ax = open(dir+"/"+d, 'r')
    sg.write(ax.read())
    sg.write("\n\n\n")
    print("Please, make sure your provided  positive histories ")
    input("Confirm that you provided examples of positive and (possibly negative) histories")
    termios.tcflush(sys.stdin, termios.TCIOFLUSH)
    

    if not os.path.isfile(dir+"/"+p):
        print ("Insufficient number of positive histories provided")
        exit(0)

    sg.write("%-------\n")
    for line in open(dir+"/"+p).readlines():
        if line in ['\n', '\r\n']:
            continue
        trace = line[line.rfind(",tr")+1:line.rfind(").")]
        if not trace in relPosTraces:
            relPosTraces.add(trace)

    if os.path.isfile(dir+"/"+n):
        for line in open(dir+"/"+n).readlines():
            if line in ['\n', '\r\n']:
                continue
            trace = line[line.rfind(",tr")+1:line.rfind(").")]
            if not trace in relNegTraces:
                relNegTraces.add(trace)

    i = 0
    sg.write("trace(")
    for tr in relPosTraces:
        if i > 0:
            sg.write(";")
        sg.write(tr)
        i += 1

    for tr in relNegTraces:
        sg.write(";")
        sg.write(tr)

    sg.write(").\n")
    i = 0
    sg.write("pos(")
    for tr in relPosTraces:
        if i > 0:
            sg.write(";")
        sg.write(tr)
        i += 1
    if len(relPosTraces) > 0:
        sg.write(").\n\n")
    j = 0
    print (relNegTraces)
    if len(relNegTraces) > 0:
        sg.write("neg(")
        for tr in relNegTraces:
            if j > 0:
                sg.write(";")
            sg.write(tr)
            j += 1
        sg.write(").\n\n")

    pos = open(dir+"/"+p, 'r')
    sg.write(pos.read())
    sg.write("\n\n")
    
    if len(relNegTraces) > 0:
        neg = open(dir+"/"+n, 'r')
        sg.write(neg.read())
        sg.write("\n\n")
    heuristics = open(dir+"/"+he, 'r')
    sg.write(heuristics.read())
    sg.write("\n\n\n")
    sg.write("clock(0.."+str(int(time)+1)+").\n\n")
    spec = open(dir+"/"+s, 'r')
    sg.write(spec.read())
    sg.write("\n\n\n")
    req = open(dir+"/"+r,'r')
    sg.write(req.read())
    sg.write("\n\n\n")
    sg.write("example(")

    for i in range(len(relPosTraces) + len(relNegTraces)):
        if i > 0:
            sg.write(";")
        sg.write("ex"+str(i+1))
    sg.write(").\n\n")

    pres_traces = get_pres_traces(dir)
    print ("\n\n Pres Traces:\n")
    print (pres_traces)
    neg_pres_traces = []
    if len(relNegTraces) > 0:
        neg_pres_traces = get_neg_pres_traces(dir)
        print ("\n\n Negative Pres Traces:\n")
        print (neg_pres_traces)
    for i in range(len(relPosTraces)):
        sg.write("ex"+str(i+1)+":-\n")
        for j in range(len(pres_traces[i])):
            if j > 0:
                sg.write(",\n")
            sg.write("\t"+pres_traces[i][j])
        sg.write(".\n\n")
    for i in range(len(relPosTraces)):
        sg.write("#example ex"+str(i + 1)+".\n")
    for i in range(len(relNegTraces)):
        sg.write("ex"+str(i+1 + int(len(relPosTraces)))+":-\n")
        for j in range(len(neg_pres_traces[i])):
            if j > 0:
                sg.write(",\n")
            sg.write("\t"+neg_pres_traces[i][j])
        sg.write(".\n\n")
    for i in range(len(relNegTraces)):
        sg.write("#example not ex"+str(i + 1 + len(relPosTraces))+".\n")

    events = get_prim_evs(dir)
    write_models(sg, events)
    sg.close()
    
    for line in open("conf.txt").readlines():
        if "clasp" in line:
            if "\n" in line:
                clasp = line[6:line.find("\n")]
            else:
                clasp = line[6:]

        if "gringo" in line:
            if "\n" in line:
                gringo = line[7:line.find("\n")]
            else:
                gringo = line[7:]
        if "xhail" in line:
            if "\n" in line:
                xhail = line[6:line.find("\n")]
            else:
                xhail = line[6:]

    bashCmd = "java -jar "+xhail+" -a  -b  -f  -m  -c "+clasp+" -g "+gringo +" "+dir+"/Spec-Learn-h"+hypNum+".lp > "+dir+"/out3"

    os.system(bashCmd)
    #elapsed = t.time() - start
    #print ("Specification generated in in "+ str(elapsed) +" seconds")
    uncFound = False
    print("\n\nSpecification:\n")
    for line in reversed(open(dir+"/out3").readlines()):
        if "uncovered" in line:
            uncFound = True
        else:
            if "hypothesis:" in line and uncFound:
                break
            else:
                if not "hypothesis:" in line and uncFound:
                    print (line[line.find("rtrig"):])



def write_models(sg, events):
    print (relEvents)
    sg.write("\n\n")
    sg.write("% ----- * Specification Language * -----\n\n")
    
    # writing modeh
    for i in events:
        sg.write("#modeh rtrig(preserve(")
        sg.write(i+"(")
        k=0
        for j in events[i]:
            if k > 0:
                sg.write(",")
            sg.write("+"+j)
            k += 1
        sg.write("),+clock), +time, +trace).\n")

    sg.write("\n")

    # writing modeb receive
    for i in events:
        sg.write("#modeb happens(receive(")
        sg.write(i+"(")
        k=0
        for j in events[i]:
            if k > 0:
                sg.write(",")
            sg.write("+"+j)
            k += 1
        sg.write("),+clock), +time, +trace).\n")
    sg.write("\n")

    # writing modeb happens_pred
    for i in events:
        lst = list(itertools.product([0, 1], repeat=len(events[i])))
        sg.write("\n")
        for conf in lst:
            k=0
            sg.write("#modeb happens_pred(preserve("+i+"(")
            for j in events[i]:
                if k > 0:
                    sg.write(",")
                if conf[k] == 0:
                    sg.write("-")
                else:
                    sg.write("+")
                sg.write(j)
                k += 1
            sg.write("),+clock), +time, +trace).\n")
    sg.write("\n")

    # writing modeb happens_prev
    for i in events:
        lst = list(itertools.product([0, 1], repeat=len(events[i])))
        sg.write("\n")
        for conf in lst:
            k=0
            sg.write("#modeb happens_prev(preserve("+i+"(")
            for j in events[i]:
                if k > 0:
                    sg.write(",")
                if conf[k] == 0:
                    sg.write("-")
                else:
                    sg.write("+")
                sg.write(j)
                k += 1
            sg.write("),+clock), +time, +trace).\n")
    sg.write("\n")

    # writing modeb not_happens_pred
    for i in events:
        lst = list(itertools.product([0, 1], repeat=len(events[i])))
        sg.write("\n")
        for conf in lst:
            k=0
            sg.write("#modeb not_happens_pred(preserve("+i+"(")
            for j in events[i]:
                if k > 0:
                    sg.write(",")
                if conf[k] == 0:
                    sg.write("-")
                else:
                    sg.write("+")
                sg.write(j)
                k += 1
            sg.write("),+clock), +time, +trace).\n")
    sg.write("\n\n")




def get_prim_evs(dir):
    params = []
    events = {}
    event = ""
    try:
        evFound=False
        zeroParams = True
        for line in open(dir+"/"+e).readlines():
            if  line.startswith("pe(")  and not evFound and not "." in line:
                
                line = line[line.find("pe(")+3:]
                
                
                event = line[:line.find("(")]
                if event in relEvents:
                    evFound = True
            

            else:
                if "pe(" in line and evFound:
                    raise InputError("Input Error","Primitive events in the Environment Definition wrongly specified ")
                else:
                    if evFound:
                        if line not in ['\n', '\r\n']:
                            
                            if zeroParams:
                                params = []
                            for p in line.split(" "):
                                if p == "\t":
                                    continue
                                st= p[:p.find("(")]
                                if st != "":
                                    st =st.replace(" ","")
                                    st =st.replace("\t","")
                                    params.append(st)
                                if zeroParams:
                                    zeroParams = False
                            if "." in line:
                                evFound = False
                                zeroParams = True
                                events[event]= params
    except InputError as ie:
        print ("Input Error: ", ie.msg)
        sys.exit(0)

    return events
        

def get_pres_traces(dir):
    pres_traces = []
    for tr in relPosTraces:
        list = []
        for line in open(dir+"/"+p).readlines():
            if ","+tr+")." in line:
                eventName = line[line.find("happens")+8:]
                eventName = eventName[:eventName.find("(")]
                relEvents.add(eventName)
                newline1= line.replace("happens","op_happens(preserve")
                
                if not ".\n" in newline1:
                    newline1= newline1.replace(","+tr+").","")
                else:
                    newline1= newline1.replace(","+tr+").\n","")
                ti = newline1[newline1.rfind(",")+1:]
                newline1 = newline1+"),"+ti+","+tr+")"
                list.append(newline1)
        pres_traces.append(list)
    return pres_traces

def get_neg_pres_traces(dir):
    pres_traces = []
    for tr in relNegTraces:
        list = []
        for line in open(dir+"/"+n).readlines():
            if ","+tr+")." in line:
                newline1= line.replace("happens","op_happens(preserve")
                if not ".\n" in newline1:
                    newline1= newline1.replace(","+tr+").","")
                else:
                    newline1= newline1.replace(","+tr+").\n","")

                ti = newline1[newline1.rfind(",")+1:]
                newline1 = newline1+"),"+ti+","+tr+")"
                list.append(newline1)
        pres_traces.append(list)
    return pres_traces


def spec_verification(dir, clingo,time,hypNum):
    try:
        if not os.path.isfile(dir+"/"+s):
            raise InputError("Input Error","Spec file missing")
        if not os.path.isfile(dir+"/"+t2):
            raise InputError("Input Error","Optimisation extension file missing")
    except InputError as ie:
        print ("Input Error: ", ie.msg)
        sys.exit(0)


    start = t.time()
    print ("*****************************************")
    print ("   Spec Verification ")
    print ("*****************************************")

    env = open(dir+"/"+e, 'r')
    sv = open(dir+"/Spec-Ver-h"+hypNum+'.lp', 'w')

    
    sv.write("time(0.."+str(time)+").\n\n")
    sv.write("trace(tr1).\n\n")
    sv.write(env.read())
    hyp = open(dir+"/"+'h'+hypNum+'.txt', 'r')
    sv.write("hyp(h"+hypNum+").\n\n")
    sv.write(hyp.read())
    sv.write("\nhypothesis(h"+hypNum+",TR):-\n")
    sv.write("\ttrace(TR),\n")
    sv.write("\ttime(T),\n")
    sv.write("\thypothesis(h"+hypNum+",T,TR).\n")
    sv.write(":- trace(TR), not hypothesis(h"+hypNum+",TR).\n\n")
    ax = open(dir+"/"+d, 'r')
    sv.write(ax.read())
    sv.write("\n\n\n")
    heuristics = open(dir+"/"+he, 'r')
    sv.write(heuristics.read())
    sv.write("\n\n\n")
    sv.write("clock(0.."+str(int(time)+1)+").\n\n")
    spec = open(dir+"/"+sver, 'r')
    sv.write(spec.read())
    sv.write("\n\n\n")
    tail2 = open(dir+"/"+t2,'r')
    sv.write(tail2.read())
    sv.close()
    bashCmd1 = clingo+" -n 0 "+dir+"/Spec-Ver-h"+hypNum+".lp > "+dir+"/out2"
    os.system(bashCmd1)
    elapsed = t.time() - start
    opt=""
    i=0
    pres_histories = np.chararray(())
    firstOptFound = False
    secondOptFound = False

    for line in reversed(open(dir+"/out2").readlines()):
        if "Optimization: " in line and not firstOptFound :
            opt= line.rstrip()
            firstOptFound = True
            continue
        if "Optimization: " in line and firstOptFound :
            if line.rstrip() == opt :
                secondOptFound = True
                continue
            else:
                break
        if secondOptFound :
            array = np.asarray(line.rstrip().split())
            if i==0:
                pres_histories = np.empty((0,len(array)), np.chararray)
                i += 1

            array = array.reshape(len(array),1)
            array = array.transpose()
            pres_histories = np.concatenate((pres_histories, array), axis=0)
            secondOptFound = False

    print ("Preservation histories not covered identified in "+ str(elapsed) +" seconds")
    return pres_histories







def history_iden(dir, clingo,time,hypNum):
    try:
        
        if not os.path.isfile(dir+"/"+e):
            raise InputError("Input Error","Environment definition missing")
        if not os.path.isfile(dir+"/"+'h'+hypNum+'.txt'):
            raise InputError("Input Error","Hypotheses definition missing")
        if not os.path.isfile(dir+"/"+d):
            raise InputError("Input Error","Domain independent axioms missing")
        if not os.path.isfile(dir+"/"+he):
            raise InputError("Input Error","Heuristics for minimal history missing")
        if not os.path.isfile(dir+"/"+t1):
            raise InputError("Input Error","Optimisation extension file missing")
    except InputError as ie:
        print ("Input Error: ", ie.msg)
        sys.exit(0)
    start = t.time()
    print ("*****************************************")
    print ("   Primitive histories identification")
    print ("*****************************************")


    env = open(dir+"/"+e, 'r')
    hi = open(dir+"/"+'history_iden-h'+hypNum+'.lp', 'w')
    time = sys.argv[1]

    hi.write("time(0.."+str(time)+").\n\n")
    hi.write("trace(tr1).\n\n")
    hi.write(env.read())
    hyp = open(dir+"/"+'h'+hypNum+'.txt', 'r')
    hi.write("hyp(h"+hypNum+").\n\n")
    hi.write(hyp.read())
    hi.write("\nhypothesis(h"+hypNum+",TR):-\n")
    hi.write("\ttrace(TR),\n")
    hi.write("\ttime(T),\n")
    hi.write("\thypothesis(h"+hypNum+",T,TR).\n")
    hi.write(":- trace(TR), not hypothesis(h"+hypNum+",TR).\n\n")
    ax = open(dir+"/"+d, 'r')
    hi.write(ax.read())
    hi.write("\n\n\n")
    heuristics = open(dir+"/"+he, 'r')
    hi.write(heuristics.read())
    hi.write("\n\n\n")
    tail = open(dir+"/"+t1, 'r')
    hi.write(tail.read())
    hi.write("\n")
    hi.close()
    bashCmd1 = clingo+" -n 0 "+dir+"/history_iden-h"+hypNum+".lp > "+dir+"/out1"
    os.system(bashCmd1)
    elapsed = t.time() - start
    out1 = open(dir+"/"+'out1','r')
    opt=""
    i=0
    j=0
    histories = np.chararray(())
    firstOptFound = False
    secondOptFound = False
    for line in reversed(open(dir+"/out1").readlines()):
        if "Optimization: " in line and not firstOptFound :
            opt= line.rstrip()
            firstOptFound = True
            continue
        if "Optimization: " in line and firstOptFound :
            if line.rstrip() == opt :
                secondOptFound = True
                continue
            else:
                break
        if secondOptFound :
            array = np.asarray(line.rstrip().split())
            if i==0:
                histories = np.empty((0,len(array)), np.chararray)
                i += 1
            array = array.reshape(len(array),1)
    
            array = array.transpose()

            histories = np.concatenate((histories, array), axis=0)
            secondOptFound = False

    print ("Histories identified in "+ str(elapsed) +" seconds")
    return histories





if __name__ == "__main__":
    main()




