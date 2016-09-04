# minorityReport
The Minority Report project aims to automatically generate specifications of forensic-ready systems that are able to maximise the usage of digital evidence whilst minimising the cost of an investigation.

Our prototype (<tt>specGeneratory.py</tt>) generates a preservation specification that prescribes to conditionally store data that might constitute evidence necessary to support a hypothesis of a potential incident. The specification consists of a set of required and trigger-conditions constraining the preservation of events that can be observed from digital devices within the environment.

It takes as input a description of the environment (file <tt>environment.txt</tt>) in which an incident may occur, and the speculative hypotheses about such incidents (files <tt>h1.txt</tt>, <tt>h2.txt</tt>,...). 
First, our prototype checks whether the hypothesis is supportable within the environment, and if so generates a set of potential positive histories (stored in file <tt>pos.txt</tt>) illustrating the sequences of events that may occur within the environment that also satisfy the hypotheses. 
Second, it generates a set of potential logs covering the potential positive histories identified in the previous step.
Finally, it asks the user to select a set of positive histories in the file <tt>pos.txt</tt> and to input a set of negative histories in the file <tt>neg.txt</tt>. Our prototype synthesizes a specification that prescribes to preserve logs that cover the positive histories and do not cover the negative ones.


![**XHAIL** output](https://github.com/lpasquale/minorityReport/blob/master/img/tool.png "**XHAIL**")

The picture shows the outputs of our prototype for the running example described in the paper. In particular, it shows the potential positive histories, the log histories covering the potential primitive histories and the synthesized specification.
