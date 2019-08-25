# Spring Boot Basics

## Environment Setup

Spring Tools Suite is an excellent IDE that can be used to develop Spring apps. Also, appropriate JDK needs to be installed before hand as well. 

## Dependencies

We can manage dependencies with ```Maven``` in ```Spring Boot```.

```Maven``` is a powerful **build tool** for Java software projects. ```Maven``` is developed in ```Java``` and is hence historically used more for Java Projects. 

We add all our dependencies in the ```pom.xml``` file and then we run a Maven command which downloads all our dependencies and also adds it to the classpath. 

### Maven Overview

```Maven``` is centered around the concept of ```**POM**``` files **(Project Object Model)**. A POM file is an XML representation of project resources like source code, test code, dependencies (external JARs used) etc. 

:warning: The POM contains references to all of these resources.

:warning: The POM file is usually placed in the root of the project. 

:boom: The POM file describes what to build, but most often not how to build it. 

## Starting a Maven Project in Pivotal STS 

Follow these steps to create a simple Maven Project - 

1. Click on ```File```
1. Select new ```Maven Project```
1. For now select ```skip ArchType Selection```
1. Provide the necessary details for the project 
1. Click on ```Finish```

