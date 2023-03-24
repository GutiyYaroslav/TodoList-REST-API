# TodoList Application with Authentication

This application is built on Spring Boot using JWT tokens for authentication.

## Requirements:
* Git
* IntelliJ IDEA
* MySQL database
* Postman

### Details:
This simple project is based on a REST API developed using Spring Boot and for security, it uses JWT tokens. The idea behind the project is to organize basic CRUD operations that you can perform with your "tasks" provided you are registered and have entered a valid JWT token.

Endpoints such as /api/v1/auth/** can be used without a JWT token for registration and authentication - after using them correctly, you will receive a JWT token generated for a specific account, which can be used for all other endpoints.
To use the obtained JWT token in all other endpoints, you need to add a "Authorization" field to the HTTP request header with the value "Bearer (your JWT token)".

This project is written using Spring Boot, Spring Security, Spring Data JPA, Spring WEB, and uses a MySQL database.


| Endpoint(without jwt token)        | Functionality                       | Request json examples                                                                                        | Response json examples                                                          |
|------------------------------------|-------------------------------------|--------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| **Post** /api/v1/auth/authenticate | Login                               | {<br/>"email":"bush@gmail.com",<br/>"password":"1234"<br/>}                                                  | {<br/>"token":"your token"<br/>}                                                |
| **Post** /api/v1/auth/register     | Signup                              | {<br/>"firstname":"George",<br/>"lastname":"Bush",<br/>"email":"bush@gmail.com",<br/>"password":"1234"<br/>} | {<br/>"token":"your token"<br/>}                                                |



| Endpoint(only with jwt token)      | Functionality                    | Request json examples                                  | Response json examples                                                          |
|------------------------------------|----------------------------------|--------------------------------------------------------|---------------------------------------------------------------------------------|
| **Post** /todos                    | Create todo for current user     | {<br/>"name":"do homework"<br/>}                       | HttpStatus.CREATED                                                              |
 | **GET** /api/v1/todos              | Get all todos from current user  |                                                        | [<br/>{<br/>"id":1,<br/>"name":"task's name",<br/>"completed":false<br/>}<br/>] |
 | **GET**/todos/{todoId}             | Get a todo by id                 |                                                        | {<br/>"id":1,<br/>"name":"task's name",<br/>"completed":false<br/>}             |
 | **PUT**/todos/{todoId}             | Update a todo by id              | {<br/>"name":"do homework",<br/>"completed":true<br/>} | {<br/>"id":"todoId",<br/>"name":"do homework",<br/>"completed":true<br/>}       |
 | **DELETE**/todos/{todoId}          | Delete a todo by id              |                                                        | HttpStatus.NO_CONTENT                                                           |



# How To Run

**Step 1**
You need to clone this repository and open the project using IntelliJ IDEA.

**Step 2**
Next, using a MySQL database, run the SQL script **to_do_list.sql** which is located in this project to create the necessary database tables
that will be created after running the project.

**Step 3**
After that, run this project using the TodoListApplication class.

**Step 4**
Finally, you can use the endpoints described above using Postman.