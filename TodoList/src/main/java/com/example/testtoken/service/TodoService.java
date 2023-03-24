package com.example.testtoken.service;

import com.example.testtoken.model.Todo;
import com.example.testtoken.model.User;

import java.util.List;

public interface TodoService {

    void addNewTodo(User user, Todo todo);

    void deleteTodo(User user, Todo todo);

    List<Todo> getAllTodos(User user);

    Todo getTodoByUserAndId(User user, Long id);

    void editTodo(Todo todo, Todo newTodoData);
}
