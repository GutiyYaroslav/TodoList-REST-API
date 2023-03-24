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


| Endpoint                           | Functionality                                          |                                                                                                           |   |
|------------------------------------|--------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|---|
| **Post** /api/v1/auth/register     | Signup (without jwt token)                             | {<br/>"firstname":"George",<br/>"lastname":"Bush",<br/>"email":"bush@gmail.com",<br/>"password":"1234"} } |   |
| **Post** /api/v1/auth/authenticate | Login (without jwt token)                              |                                                                                                           |   |
| **GET** /api/v1/todos              | Get all todos from current user (only with jwt token)  |                                                                                                           |   |
| **Post** /todos                    | Create todo for current user (only with jwt token)     |                                                                                                           |   |
| **GET**/todos/{todoId}             | Get a todo by id (only with jwt token)                 |                                                                                                           |   |
| **PUT**/todos/{todoId}             | Update a todo by id (only with jwt token)              |                                                                                                           |   |
| **DELETE**/todos/{todoId}          | Delete a todo by id (only with jwt token)              |                                                                                                           |   |



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