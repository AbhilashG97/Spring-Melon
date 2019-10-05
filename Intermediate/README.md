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

## Creating a Simple API 

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

:boom: [Postman](https://www.getpostman.com/) can be used to test the API. 

### Allowed API calls

| API Method | API Url                            | Description                                                                                                |
|------------|------------------------------------|------------------------------------------------------------------------------------------------------------|
| **GET**        | ```BASE_URL/fruits```              | Displays all the fruits                                                                                    |
| **GET**        | ```BASE_URL/fruits/{fruit_name}``` | Displays the specified fruit, where ```{fruit_name}``` contains the name of the fruit.                     |
| **POST**       | ```BASE_URL/fruits```              | Adds a fruit to the database. The fruit to be added has to be specified in the request body.               |
| **PUT**        | ```BASE_URL/fruits``` | Updates the value of the fruit specified. The data to be modified has to be specified in the request body. |
| **DELETE**     | ```BASE_URL/fruits/{fruit_name}``` | Deletes the fruit specified. The fruit to be deleted has to be specified in the request body.              |

## Creating an API with two Datatables

This is an extension of the previous section. Here we will create an API which fetchs data from two tables. 

We will be creating a mock Fruit-Dessert API. 

A sample project can be found [here](#)

We will be using an embedded database called ```DerbyDB``` to create the Datatables. In order to create the two tables, we will create two model classes which are associated with each other.

In our class each ```Fruit``` can have many ```Dessert``` dishes made from it. This implies that ```Fruit``` and ```Dessert``` are in **one-to-many** relationship.

Sample Datatable for the both the classes are shown below - 

**```Fruit``` Table**

| Id (Primary Key) |    Name    | Price |
|:----------------:|:----------:|:-----:|
| 0                | Watermelon | 100   |
| 1                | Oranges    | 150   |
| 2                | Peaches    | 200   |
| 3                | Lychee     | 400   |
| ....             | ....       | ....  |

**```Dessert``` Table**

| Id (Primary Key) | Fruit ID (Foreign Key) |        Name       | Description                                                  | Price |
|:----------------:|------------------------|:-----------------:|--------------------------------------------------------------|:-----:|
| 0                | 0                      | Watermelon Mouse  | A delicious watermelon mouse with watermelon shavings on top | 100   |
| 1                | 0                      | Watermelon Cake   | A very delicious cake                                        | 150   |
| 2                | 3                      | Lychee Cheesecake | The best Lychee Cheesecake in the world                      | 200   |
| 3                | 3                      | Lychee Milkshake  | A deolicious lychee milkshake                                | 400   |
| ....             | ....                   | ....              | ....                                                         | ....  |

```@ManyToOne``` annotation is used in the ```Dessert``` class to specify its dependency on the Fruit class.

:warning: The ```Controllers```, ```Services``` and ```Repositories``` are created as usual. 

