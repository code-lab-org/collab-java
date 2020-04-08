# collab-java

Collaborative Design Tool (in Java)

## Introduction

This project provides a simple graphical user interface for a multi-actor collaborative design study with surrogate parameter design tasks. It includes a manager application to control the advancement of tasks and a designer application to modify input variables and visualize output variables.

## Pre-requisites

This project uses a Maven build file (`pom.xml`) to configure most external dependencies.

In addition, you must have an IEEE Std. 1516-2010 High Level Architecture (HLA) runtime infrastructure (RTI) to use this software. The included Maven configuration assumes you are using version 2.1.0 of the open source [Portico RTI](http://www.porticoproject.org/) with the environment variable RTI_HOME set to the install path. The software has also been tested with the commercial Pitch pRTI implementation. You can specify the RTI implementation by editing the `rtiName` property in the configuration file `config.properties`.

Other configuration options in the `config.properties` file modify the path to the federation object model (FOM) file (default: `collab.xml` in project root) and the federation name (to allow more than one federation on one network, for example).

## Running the Program

The main class `DebugMain` launches one manager GUI and three designer GUIs. It is suitable for local testing and debugging on one host.

Alternatively, launch independent clients using main classes `ManagerMain` and `DesignerMain`. Note the manager must be launched first to correctly register designers. The designer applications expect a command argument to identify the designer index (0-based). Note that Portico uses UDP multicast transmission which may be filtered or blocked on commercial or enterprise computer networks. Consider using a local area network or private wireless network to allow each client to communicate with the others.

Sample experiments are defined in the `src/generator` directory. Load an experiment from the manager application to start a design session.

During an experiment, the application writes log files to the default execution directory.

## Acknowledgements

This project was funded, in part, by a National Defense Science and Engineering Graduate (NDSEG) Fellowship.

## References

P.T. Grogan and O.L. de Weck (2016). "Collaboration and complexity: An experiment on the effect of multi-actor coupled design," *Research in Engineering Design*, vol. 27, pp. 221--235. doi: [10.1007/s00163-016-0214-7](https://doi.org/10.1007/s00163-016-0214-7). 

A. Alelyani, Y. Yang, and P.T. Grogan (2017). "Understanding designers' behaviors in parameter design activities," in *2017 ASME International Design Engineering Technical Conferences & Computers and Information in Engineering Conference*, Cleveland, OH. doi: [10.115/DETC2017-68335](https://doi.org/10.115/DETC2017-68335). 

P.T. Grogan (2018). "Data on multi-actor parameter design tasks by engineering students with variable problem size, coupling, and team size," *Data in Brief*, vol. 20, pp. 1079--1084. doi: [10.1017/dsj.2019.23](https://doi.org/10.1017/dsj.2019.23).