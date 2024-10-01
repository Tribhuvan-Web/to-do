package com.example.Section_13;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@SessionAttributes("name")
public class toDoController {

    private toDoService tDoService;

    public toDoController(toDoService tDoService) {
        super();
        this.tDoService = tDoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = tDoService.findByUserName("reyansh");
        model.addAttribute("todos", todos);
        return "list";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, Todo todo) {
        String userName = (String) model.get("name");
        toDoService.addTodo(userName, todo.getDescription(), LocalDate.now().plusYears(1),
                false);
        return "redirect:list-todos";
    }

}
