package com.example.Section_13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class toDoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int count = 0;

    static {
        todos.add(new Todo(++count, "Reyansh", "Springboot", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++count, "Amit", "JavaScript", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++count, "Ritik", "Flutter", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String userName) {
        return todos;
    }

    public static void addTodo(String userName, String description, LocalDate tagretDate, boolean done) {
        Todo to = new Todo(++count, userName, description, tagretDate, done);
        todos.add(to);
    }

    public void deleteTodo(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
