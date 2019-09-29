= Merge Utility App

== Introduction

A command line utility that combines the contents from a list of PDF files into a single PDF file.

The project use Maven to:

* Build a project;
* Add dependencies;
* Run tests cases;

== Prerequisites

* Java 8 or higher;
* Maven (Only if you want to build the project);
* JDK 8 or higher (Only if you want to build the project);

== Usage

The "target" folder contains the latest version of the project already builded.

The command 

----
java -jar merge-utility-app-1.0-SNAPSHOT-jar-with-dependencies.jar <COMMAND_NAME> -f <SOURCE_FILE_TYPE> -t <TARGET_FILE_NAME> -s <SOURCE_FILE_NAMES> 
----

Where: 

	-f: source file type (pdf, csv, html, txt, etc.)
    -t: new file name that will be create
	-s: list list of source files spliy by spaces

A full example invocation could look like this:

----
java -jar .\merge-utility-app-1.0-SNAPSHOT-jar-with-dependencies.jar merge -f pdf -t c:/svn/novo.pdf -s c:/svn/file.pdf c:/svn/teste4.pdf
----

== Build Project

If you want to build the project enter the command in the main folder:

---
mvn clean install
---
