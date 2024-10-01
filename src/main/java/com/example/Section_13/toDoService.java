package com.example.Section_13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
}
