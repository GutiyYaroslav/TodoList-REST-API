package com.example.testtoken.controller;


import com.example.testtoken.exception.ResourceNotFoundException;
import com.example.testtoken.model.Todo;
import com.example.testtoken.model.User;
import com.example.testtoken.service.TodoService;
import com.example.testtoken.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodosByUser(Authentication authentication){
        User currentUser = userService.getUserByEmail(authentication.getName());
        return new ResponseEntity<>(todoService.getAllTodos(currentUser), HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoByIdFromUser(@PathVariable("todoId") Long todoId, Authentication authentication){
        User currentUser = userService.getUserByEmail(authentication.getName());
        Todo todo = todoService.getTodoByUserAndId(currentUser, todoId);
        if(todo == null){
            return new ResponseEntity<>((Todo) null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addNewTodo(@RequestBody Todo todo, Authentication authentication){
        User currentUser = userService.getUserByEmail(authentication.getName());
        todoService.addNewTodo(currentUser, todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("todoId") Long todoId, Authentication authentication){
        User currentUser = userService.getUserByEmail(authentication.getName());
        Todo todo = todoService.getTodoByUserAndId(currentUser, todoId);
        todoService.deleteTodo(currentUser, todo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{todoId}")

    public ResponseEntity<Todo> editTodo(@RequestBody Todo newTodoData, @PathVariable("todoId") Long todoId, Authentication authentication) throws ResourceNotFoundException {
        User currentUser = userService.getUserByEmail(authentication.getName());
        Todo currentTodo = todoService.getTodoByUserAndId(currentUser, todoId);
        if(todoService.getTodoByUserAndId(currentUser, todoId) != null){
            todoService.editTodo(currentTodo, newTodoData);
            todoService.addNewTodo(currentUser, currentTodo);
        }else{
            throw new ResourceNotFoundException("Todo with + " + todoId + "not found");
        }
        return new ResponseEntity<>(currentTodo, HttpStatus.OK);
    }
}
