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

Here is a sample ```POM``` file - 

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.abhilashg.watermelon</groupId>
	<artifactId>fruit-api</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Simple Fruit API</name>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.7.RELEASE</version>
	</parent>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-parent</artifactId>
			<version>2.1.7.RELEASE</version>
			<type>pom</type>
		</dependency>
	</dependencies>

	<properties>
		<java.version>1.8</java.version>
	</properties>
</project>
```

:boom: In the above code snippet, the ```parent tag``` contains the ```parent POM``` for the current ```child POM```.

#### Super POM and and POM Inheritance 

All Maven ```POM``` files inherit from a super ```POM```. If no super ```POM``` is specified, the ```POM``` file inherits from the base ```POM```. 

A ```POM``` file can explicitly inherit from another ```POM``` file. That way you can change the settings across all inheriting ```POM```'s via their common super ```POM```.

#### Effective POM

The total ```POM``` file (result of all inheritance) is called the effective ```POM```.  ```POM``` files may inherit from a lot of other ```POM``` files and it may become difficult to view how the resultant POM looks like at the end. For that we make use of effective ```POM```.

#### Maven Repositories

> A repository in Maven holds build artifacts and dependencies of varying types.

There are two types of repositories - 

1.  **Local Repositories**
1.  **Remote Repositories**

> The local repository is a directory on the computer where Maven runs. It caches remote downloads and contains temporary build artifacts that you have not yet released.

> Remote repositories refer to any other type of repository, accessed by a variety of protocols such as file:// and http://. These repositories might be a truly remote repository set up by a third party to provide their artifacts for downloading (for example, repo.maven.apache.org and uk.maven.org house Maven's central repository)

:boom: Maven also has another repository called the **Central Repository**. The central Maven repository is a repository provided by the Maven community. 

:exclamation: By default Maven looks in central repository for any dependencies needed but not found in your local repository.

#### Snapshot Dependencies

Snapshot dependencies are dependencies (JAR files) which are under development.

 Instead of constantly updating the version numbers to get the latest version, you can depend on a snapshot version of the project. Snapshot versions are always downloaded into your local repository for every build, even if a matching snapshot version is already located in your local repository.

 :boom: You can tell Maven that your project is a snapshot version simply by appending -SNAPSHOT to the version number in the beginning of the ```POM```

## Starting a Maven Project in Pivotal STS 

Follow these steps to create a simple Maven Project - 

1.	Click on ```File```
1.	Select new ```Maven Project```
1.	For now select ```skip ArchType Selection```
	1.	```ArchType``` provides different templates for a Maven Project.	
1.	Provide the necessary details for the project 
1.	Click on ```Finish```

:warning: We can create resolve most issues by using ```Ctrl + 1``` in Windows. It is equivalent to ```Alt + Enter``` in ```Android Studio```.

:warning: Unused imports can be removed in STS by pressing ```Ctrl + Shift + O```.

## Creating a Simple SpringBootApplication 

A ```main()``` method is required to start a Spring Boot application. The class which contains the ```main()``` method needs to be annotated with ```@SpringBootApplication```. 

The ```@SpringBootApplication``` annotation does the following three things - 

1.	Do ```auto-configuration``` 
1.	Do ```component scan```
1.	Do extra configuration stuff on their application class. 

A single ```@SpringBootApplication``` is equivalent to the following - 

1.	```@EnableAutoConfiguration```: enable Spring Boot’s auto-configuration mechanism
1.	```@ComponentScan```: enable @Component scan on the package where the application is located (see the best practices)
1.	```@Configuration```: allow to register extra beans in the context or import additional configuration classes

:boom: A Spring application can be started using the static ```run()``` method of the ```SpringApplication``` class.

Here is a code snippet - 

```java 
@SpringBootApplication 
public class FruitApiApp {
	public static void main(String[] args) {
		SpringApplication.run(FruitApiApp.class, args);
	}
}
```

## Adding a Controller 

Controller is a part of the ```Spring Web MVC```. 

One of the things that a controller does is to map urls to their content. 

A Controller class is annotated with ```@RestController``` annotation. Also, a method can be mapped to a method by making use of the ```@RequestMapping``` annotation.

