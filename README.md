# minorityReport
The Minority Report project aims to automatically generate specifications of forensic-ready systems that are able to maximise the usage of digital evidence whilst minimising the cost of an investigation.

Our prototype (<tt>specGeneratory.py</tt>) generates a preservation specification that prescribes to conditionally store data that might constitute evidence necessary to support a hypothesis of a potential incident. The specification consists of a set of required and trigger-conditions constraining the preservation of events that can be observed from digital devices within the environment.

It takes as input a description of the environment (file <tt>environment.txt</tt>) in which an incident may occur, and the speculative hypotheses about such incidents (files <tt>h1.txt</tt>, <tt>h2.txt</tt>,...). 
First, our prototype checks whether the hypothesis is supportable within the environment, and if so generates a set of potential positive histories (stored in file <tt>pos.txt</tt>) illustrating the sequences of events that may occur within the environment that also satisfy the hypotheses. 
Second, it generates a set of potential logs covering the potential positive histories identified in the previous step.
Finally, it asks the user to select a set of positive histories in the file <tt>pos.txt</tt> and to input a set of negative histories in the file <tt>neg.txt</tt>. Our prototype synthesizes a specification that prescribes to preserve logs that cover the positive histories and do not cover the negative ones.


![**XHAIL** output](https://github.com/lpasquale/minorityReport/blob/master/img/tool.png "**XHAIL**")

The picture shows the outputs of our prototype for the running example described in the paper. In particular, it shows the potential positive histories, the log histories covering the potential primitive histories and the synthesized specification.

Requirements
------------
This repository contains the source code of our prototype, the inputs (environment and hypotheses) associated with the running example and the two case studies described in the paper.
To run these examples, the application prototype must be properly configured.
The following sections describe the steps required to use the **Minority Report** prototype to synthesize preservation specifications.

### Prerequisites

The **Minority Report** prototype is a *Python* application, requiring Python 3.5 to be installed on the target machine to run it. 

Our prototype delegates some of the reasoning tasks it performs to an external *ASP* engine (Clingo) and to a **Inductive Logic Programming** (XHAIL) system which are therefore required to make it work properly. 

he *ASP* platform that we have chosen to use is *Clingo*/*Clingo*/*Clasp*.
In particular, we recommend to use Clingo v3.0.5, Gringo v3.05 and Clasp v3.0.3.
These tools are part of the *Potsdam Answer Set Solving Collection* (POTASSCO), more information is available on the [web site](http://potassco.sourceforge.net) of the project.

You can download sources from the official web site, but you can also conveniently find compiled binaries on [SourceForge](http://sourceforge.net/projects/potassco/) in the *Files* section. 
You need to repeat the following steps for *Clingo*, *Gringo*, and *Clasp* 
Enter *Clingo*'s (*Gringo*'s,*Clasp*'s) folder and then the folder for the most recent version among those of the 3rd major release.
Now select the package that is appropriate for your system and the download should start in a few seconds.
Further instructions are provided within the package.
Please take note of the folder where the binaries will sit as it will be needed later.


