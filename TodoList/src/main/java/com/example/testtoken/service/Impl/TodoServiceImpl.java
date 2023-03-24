package com.example.testtoken.service.Impl;

import com.example.testtoken.model.Todo;
import com.example.testtoken.model.User;
import com.example.testtoken.repository.TodoRepository;
import com.example.testtoken.repository.UserRepository;
import com.example.testtoken.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Override
    public void addNewTodo(User user, Todo todo) {
        log.info("IN TodoServiceImpl method addNewTodo() - add todo to user with id {}", user.getId());
        todo.setUser(user);
        user.addTodo(todo);
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(User user, Todo todo) {
        log.info("IN TodoServiceImpl method deleteTodo() - remove todo with id {}", todo.getId());
        user.deleteTodo(todo);
        todoRepository.delete(todo);
    }

    @Override
    public List<Todo> getAllTodos(User user) {
        log.info("IN TodoServiceImpl method getAllTodos() - get all todo");
        List<Todo> todoList = todoRepository.findByUser(user);
        return todoList;
    }

    @Override
    public Todo getTodoByUserAndId(User user, Long todoId) {
        log.info("IN TodoServiceImpl method getTodoByUserAndId() - id {}", todoId);
        return todoRepository.findByUserAndId(user, todoId);
    }

    @Override
    public void editTodo(Todo todo, Todo newTodoData) {
        log.info("IN TodoServiceImpl method editTodo() - todo - id {}", todo.getId());
        todo.setContent(newTodoData.getContent());
        todo.setCompleted(newTodoData.getCompleted());
    }
}
