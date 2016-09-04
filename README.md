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
This repository contains the source code of our prototype, the inputs (environment and hypotheses) associated with the running example and the two case studies described in the paper.
To run these examples, the application prototype must be properly configured.
The following sections describe the steps required to use the **Minority Report** prototype to synthesize preservation specifications.

### Prerequisites

The **Minority Report** prototype is a *Python* application, requiring Python 3.5 to be installed on the target machine to run it. 

Our prototype delegates some of the reasoning tasks it performs to an external **ASP** engine (Clingo) and to an **Inductive Logic Programming** (XHAIL) system which are therefore required to make it work properly. 

The *ASP* platform that we have chosen to use is *Clingo*/*Gringo*/*Clasp*.
These tools are part of the *Potsdam Answer Set Solving Collection* (POTASSCO); more information about how to obtain and install them is available on the [web site](http://potassco.sourceforge.net) of the project.
In particular, we use version 3 of Clingo, Gringo, and Clasp. Usage of higher versions of these tool would lead to errors.

The Inductive Logic Programming System that we use is XHAIL. More information about how to obtain and install XHAIL is available on the [web site](https://github.com/stefano-bragaglia/XHAIL) of the project. 

Running the examples
---------------------
Place files specGenerator.py and conf.txt in the same directory.

Place the file environment.txt and h1.txt, h2.txt,... also including additional files in the addFiles directory. in a specific target directory.

Configure the conf.txt file by identifying the directory in which the inputs and the additional files necessary to generate a specification are placed, and the path to clingo, clasp and gringo commands and xhail.jar library.
An example configuration can look like the following.

dir=/Users/liliana/webpage/running
clingo=/Users/liliana/clingo-3.0.5-macos-10.8.3/clingo
clasp=/Users/liliana/clasp-3.0.3/clasp
gringo=/Users/liliana/gringo/gringo
xhail=/usr/local/xhail-0.5.1/xhail.jar

run .specGenerator.py by providing as input the maximum length desired for a history and the hypothesis number

dhcp-c101a4a2:MR liliana$ python3.5 specGenerator.py 6 1

When required to provide as input positive and negative potential histories make sure to edit files pos.txt and neg.txt in the target directory. Examples of positive and negative histories are provided for each hypothesis included in the examples.
