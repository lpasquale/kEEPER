# minorityReport
The Minority Report project aims to automatically generate specifications of forensic-ready systems that are able to maximise the usage of digital evidence whilst minimising the cost of an investigation.

Our prototype (<tt>specGeneratory.py</tt>) generates a preservation specification that prescribes to conditionally store data that might constitute evidence necessary to support a hypothesis of a potential incident. It takes as input a description of the environment in which an incident may occur, and the speculative hypotheses about such incidents. First, our prototype checks whether the hypothesis is supportable within the environment, and if so generates a set of potential positive histories illustrating the sequences of events that may occur within the environment that also satisfy the hypotheses.


