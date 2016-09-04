# minorityReport
The Minority Report project aims to automatically generate specifications of forensic-ready systems that are able to maximise the usage of digital evidence whilst minimising the cost of an investigation.

Our prototype (<tt>specGeneratory.py</tt>) generates a preservation specification that prescribes to conditionally store data that might constitute evidence necessary to support a hypothesis of a potential incident. The specification consists of a set of required and trigger-conditions constraining the preservation of events that can be observed from digital devices within the environment.

Our prototype takes as input a description of the environment (file <tt>environment.txt</tt>) in which an incident may occur, and the speculative hypotheses about such incidents (files <tt>h1.txt</tt>, <tt>h2.txt</tt>,...). 

First, our prototype checks whether the hypothesis is supportable within the environment, and if so generates a set of potential positive histories (stored in file <tt>pos.txt</tt>) illustrating the sequences of events that may occur within the environment that also satisfy the hypothesis. 
Second, the prototype generates a set of potential logs covering the potential positive histories identified in the previous step.
Finally, it asks the user to select a set of positive histories (in the file <tt>pos.txt</tt>) and to input a set of negative histories (in the file <tt>neg.txt</tt>). Our prototype synthesizes a specification that prescribes to preserve logs that cover the positive histories and do not cover the negative ones.


![**XHAIL** output](https://github.com/lpasquale/minorityReport/blob/master/img/tool.png "**XHAIL**")

The picture shows the outputs of our prototype for the running example described in the paper. In particular, it shows the potential positive histories, the log histories covering the potential primitive histories and the synthesized specification.

Requirements
------------
This repository contains the source code of our prototype (file <tt>specGenerator.py</tt>), a configuration file (<tt>conf.txt</tt>), some additional files necessary to support the specification generation (inside directory <tt>AddFiles</tt>), and the inputs (environment and hypotheses) associated with the running example and the two case studies described in the paper (directories <tt>RunningExample</tt>, <tt>HarassmentScenario</tt> and <tt>ExfiltrationScenario</tt>, respectively).
To run these examples, the application prototype must be configured properly.
The following sections describe the steps required to use the our prototype to synthesize preservation specifications.

### Prerequisites

Our prototype is a *Python* application requiring Python 3.5 to be installed on the target machine to run it. <br>
Our prototype delegates some of the reasoning tasks it performs to an external **ASP** engine (Clingo) and to an **Inductive Logic Programming** (XHAIL) system which are therefore required to make it work properly. 

The *ASP* platform that we have chosen to use is *Clingo*/*Gringo*/*Clasp*.<br>
These tools are part of the *Potsdam Answer Set Solving Collection* (POTASSCO); more information about how to obtain and install them is available on the [web site](http://potassco.sourceforge.net) of the project.<br>
We use version 3 of Clingo, Gringo, and Clasp. Usage of higher versions of these tools would lead to errors.<br>
Morevoer, the PATH Environment Variable should point to Clingo, Gringo and Clasp target folders.

The Inductive Logic Programming System that we use is *XHAIL*. More information about how to obtain and install XHAIL is available on the [web site](https://github.com/stefano-bragaglia/XHAIL) of the project. 

### Running the examples

To run the examples, please follow the following steps:
<ul>
<li> Place files <tt>specGenerator.py</tt> and <tt>conf.txt</tt> in the same directory. </li>

<li> Place the environment description (<tt>environment.txt</tt>), the hypotheses (<tt>h1.txt</tt>, <tt>h2.txt</tt>,...) and the additional files (in directory <tt>AddFiles</tt>) in the same directory. This directory could be the same in which files <tt>specGenerator.py</tt> and <tt>conf.txt</tt> are placed (although it does not have to be). </li>

<li> Edit file <tt>conf.txt</tt>.<br> In particular, <tt>dir</tt> should point to the directory in which the environment description is placed. The other entries should point to the <tt>clingo</tt>, <tt>clasp</tt> and <tt>gringo</tt> commands and the <tt>xhail.jar</tt> library.

An example configuration can look like the following. <br>
<tt>dir=/Users/liliana/webpage/running</tt><br>
<tt>clingo=/Users/liliana/clingo-3.0.5-macos-10.8.3/clingo</tt><br>
<tt>clasp=/Users/liliana/clasp-3.0.3/clasp</tt><br>
<tt>gringo=/Users/liliana/gringo/gringo</tt><br>
<tt>xhail=/usr/local/xhail-0.5.1/xhail.jar</tt> </li>

<li>run <tt>specGenerator.py</tt> providing as input the maximum time window for a history and the hypothesis number. <br> For example, the following command runs our prototype, setting the maximum time window to 6 and considering hypothesis 1 (represented in file <tt>h1.txt</tt>).<br>
<tt>python3.5 specGenerator.py 6 1</tt> </li>

<li>While running, our tool requires the user to provide as input potential positive and negative histories. <br> 
The user should do so by editing files <tt>pos.txt</tt> and <tt>neg.txt</tt> in the directory where the environment description is placed. Together with the environment descrition, in the examples directories (<tt>RunningExample</tt>, <tt>HarassmentScenario</tt> and <tt>ExfiltrationScenario</tt>) we also provide examples of positive and negative histories for each hypothesis. For example, for hypothesis h2 of the harassment scenario, examples of positive and negative potential histories are in files <tt>pos-h2.txt</tt> and <tt>neg-h2.txt</tt>, respectively. The same applies to the other hypotheses. The content of these files could/should be copied in files <tt>pos.txt</tt> and <tt>neg.txt</tt> when prompted. </li>
</ul>








