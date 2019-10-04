# :leaves: Spring Boot Intermediate :leaves:

## Spring Data JPA

**JPA** stands for ```Java Persistence API``` which is an API that assists us to perform ORM (Object Relational Mapping) operations. 

**Spring Boot JPA** adds more functionality to the ```JPA```. 

:radioactive: [This](https://huongdanjava.com/create-new-spring-boot-project-using-spring-tool-suite.html) is a good blog which mentions in great detail how to start a new Spring Project.

## Starting a Spring Boot Project 

To start a new Sring Project, the Spring Starter Project option can be used. Select the appropriate dependencies and then start working on the project. 

The dependencies that were selected for the current sample project are as follows - 

1.  **Spring JPA**
1.  **Spring Web**
1.  **Spring Apache Derby**

:radioactive: **Apache Derby** is a database that is embedded into the Spring Boot framework and it doesn't require to be initialized separately.

## Creating the API 

In order to make use of the database, we have to create a custom Repository by extending the ```CrudRepository```. The instance of the custom ```CrudRepository``` interface needs to be then injecting into the ```Service``` class. 

The various ```CRUD``` operations can then be performed using the methods of the ```CrudRepository```. 

A sample project can be found [here](https://github.com/AbhilashG97/Spring-Melon/tree/master/Intermediate/Fruit-API-Data).

The data table for the above mentioned project looks somewhat like this - 
  
| Name (Primary Key)  | Price |
|---------------------|-------|
| Watermelon          | 100   |
| Oranges             | 150   |
| Peaches             | 200   |
| Lychee              | 400   |
| ....                | ....  |

:warning: In the above project, **name** is set as the primary key, which is a bad design. 
