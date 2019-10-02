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

:radioactive: Without the ```dependencies``` section, no maven dependencies will be downloaded. 

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

A Controller class is annotated with ```@RestController``` annotation. Also, a ```URL``` can be mapped to a method by making use of the ```@RequestMapping``` annotation. The ```@RequestMapping``` annotation takes in a parameter which directs to the ```URL``` of the mapped method. 

Here is an example - 

```java 
@RestController
public class Greeting {
	
	@RequestMapping("/greeting")
	public String greeting() {
		return "Hello, Watermelon!";
	}
}
```

:warning: The ```@RequestMapping``` maps only ```GET``` method by default. To map other HTTP methods we'll need to specify it in the annotation.  

Here is another example - 

```java 
@RestController
public class FruitApi {

	@RequestMapping("/fruits")
	public List<Fruit> getFruitList() {
		return Arrays.asList(new Fruit("Watermelon", 123), new Fruit("Mango", 343), new Fruit("Sweet Lime", 321),
				new Fruit("Dragon Fruit", 334), new Fruit("Soursop", 232));
	}

}
```

In the above example a list of fruits is returned. 

:radioactive: ```@RequestMapping``` annotation automatically converts the list of fruits which is returned to a ```JSON``` object array. Spring Boot takes care of the return value and it makes sure that a ```json``` is returned for methods annotated with ```@RequestMapping```.  

## Bill of Materials

In ```Spring Boot``` we can import a bunch of libraries which work well together directly by invoking the parent and specifying it's version number along with it. 

This is known as ```Bill of Materials``` or ```BOM```.

## Embedded Tomcat Server

This section highlights the advantages of having a embedded tomcat server - 

1.	Convenience
1.	Servelet container config in now application config
1.	Standalone application
1.	Useful for Microservices architecture

## Building the API

In order to build an API, we need to first think of the resources that we want to provide. In our case that resource is ```fruit```. 

We need to provide various ways with which we can interact with the resource. Here are a few ways - 

1.	**```/GET```** 
	```/fruits``` -> returns all the fruits in the database

1.	**```/GET```**
	```/fruits/id``` -> returns a fruit with ```ID``` specified.

1.	**```/POST```**
	```/fruits``` -> create a new fruit

1.	**```/PUT```**
	```/fruits/id``` -> edit the fruit present in the database. 

1.	**```/DELETE```**
	```fruits/id``` -> delete a fruit with the id specified.

## Creating a Business Service

A business service can be created by making use of the ```@Service``` annotation. The ```@Service``` annotation is provided to the class providing the resource.

The service class is then called in a class that needs this service. 

:radioactive: The class needing the service is called a ```Dependency```. 

The dependency class can be provided using the ```@Autowired``` annotation.

Here is an example - 

The below code snippet shows a ```Service```.

```java
@Service
public class FruitService {

	private ArrayList<Fruit> fruits = new ArrayList<>();
	
	public ArrayList<Fruit> getFruits() {
		fruits.add(new Fruit("Watermelon", 100));
		fruits.add(new Fruit("Apple", 140));
		fruits.add(new Fruit("Orange", 350));
		fruits.add(new Fruit("Mango", 500));
		fruits.add(new Fruit("Dragon-fruit", 200));
		fruits.add(new Fruit("Soursop", 1200));
		fruits.add(new Fruit("Star-fruit", 145));
		fruits.add(new Fruit("Sweet Lime", 123));
		return fruits;
	}
	
}
```

The below code snippet shows a dependency being injected in the controller class which requires the dependency.

```java 
@RestController
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	@RequestMapping("")
	public String sayHello() {
		return "Hello, World!";
	}
	
	@RequestMapping("/fruits")
	public ArrayList<Fruit> getFruitData() {
		return fruitService.getFruits();
	}
}
```

## Returning a single resource from a business service

The ```Service``` class can be used to return a single resource to the dependent class by making use of the ```@PathVariable``` annotation. 

Here is an example -

The code snippet shown below is for the ```Service```.

```java 
public Fruit getFruit(String fruit) {
	return fruits.stream().filter((fruitValue) -> fruitValue.getName().toLowerCase().equals(fruit.toLowerCase()))
			.findFirst().get();
}
```

The code snippet shown below is for the Contoller - 

```java 
@RequestMapping("/fruits/{fruit}")
public Fruit getFruit(@PathVariable String fruit) {
	return fruitService.getFruit(fruit);
}
```

## Sending a POST Request

Sending a ```POST``` request is a bit more complicated then sending a ```GET``` request. 

The ```@RequestMapping``` annotation can be used to send a ```POST``` request. Two parameters are passed with the ```@RequestMapping``` annotation. 

The two parameters that are passed are - 

1.	**```value```**	

	This argument contains the URL for the POST request.

1.	**```method```**

	This argument contains the method type for the HTTP request(e.g. ```GET```, ```POST```, ```PUT```, ```DELETE```). 

The ```Service``` class is also modified accordingly to include the ```POST``` request. 

:radioactive: ```@RequestBody``` annotation is used to include the payload for the ```POST``` request. It has to be provided by the client sending the ```POST``` request. The ```Content-Type``` for the header is usually set to ```application/json```.

:warning: Software like [Postman](https://www.getpostman.com/) can be used to send ```POST``` requests with ease. 

Here is an example - 

Code snippet for the ```Service``` class is shown below -

```java 
public void addFruit(Fruit fruit) {
	fruits.add(fruit);
}
```

Code snippet for the ```Controller``` is shown below -

```java 
@RequestMapping(value="/fruits", method=RequestMethod.POST)
public void addFruit(@RequestBody Fruit fruit) {
	fruitService.addFruit(fruit);
}
```

## Implementing UPDATE and DELETE 

The ```UPDATE``` and ```DELETE``` HTTP methods are similar to the ```POST``` http method when implementing them in Spring Boot.

1.	**```UPDATE```** HTTP method
	
	The update http method is used to update a particular item on the remote server. In order to send a UPDATE request the following needs to be done - 

	1.	Use the ```@RequestMapping``` annotation with ```value``` and ```method``` as its parameters. 
	1.	In the Java method, ```@PathVariable``` has to be specified which points to the item that needs to be modified on the remote server.       

	Here is an example for the same - 

	The code for the ```Controller``` is shown below -

	```java 
	@RequestMapping(value="/fruits/{fruitName}", method=RequestMethod.PUT)
	public void updateFruit(@PathVariable String fruitName, @RequestBody Fruit fruit) {
		fruitService.updateFruit(fruitName, fruit);
	}
	```

	The code for the ```Service``` is shown below -

	```java 
	public void updateFruit(String fruitName, Fruit fruit) {
		fruits = fruits.stream()
		.map(fruitValue -> fruitValue.getName().toLowerCase().equals(fruitName.toLowerCase()) ? fruit : fruitValue)
		.collect(Collectors.toCollection(ArrayList::new));
	}	 
	```

1.	**```DELETE```** HTTP method

	The ```DELETE``` HTTP method is also quite easy to implement. It can be implemented using the ```@RequestMapping``` annotation with ```value``` and ```method``` as its parameters. The item specified in the ```value``` parameter of the annotation is passed to the Java method. Then the appropriate method is written in the ```Service``` class which handles the request. 

	Here is an example - 

	Code for the ```Controller``` class is shown below - 

	```java 
	@RequestMapping(value="/fruits/{fruitName}", method=RequestMethod.DELETE)
	public void deleteFruit(@PathVariable String fruitName) {
		fruitService.deleteFruit(fruitName);
	}
	```  

	Code for the ```Service``` class is shown below - 

	```java 
	public void deleteFruit(String fruitName) {
		fruits.removeIf(fruit -> fruit.getName().toLowerCase().equals(fruitName.toLowerCase()));
	}	
	```
## Initializing a Spring project

A Spring Boot project cam be initialized in a number of ways. Some of them are mentioned below - 

1.	[Spring Initialir](https://start.spring.io/)
1.	[Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)
1.	STS IDE
1.	Configure a Spring Boot project from a bare minimum maven project.

:boom: All the methods mentioned above provide a starting Spring Boot project which can be built upon later.

## Configuring a Spring Project 

A few properties of a Spring Project can be changed by specifying the configurations in the ```application.properties``` file. Things like the default port in which the Spring Boot application starts can be configured among other things. 

The ```applications.properties``` file is placed inside the resources folder. 

:warning: Everything inside the ```application.properties``` file is stored in key-value pairs.

:radioactive: The list of all the key-value pairs of the ```application.properties``` file can be found [here](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html). 