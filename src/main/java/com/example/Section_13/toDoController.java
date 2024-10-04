package com.example.Section_13;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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

    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id) {
        tDoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "Default Description ", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpDateToDo(@RequestParam int id, ModelMap model) {
        Todo todo = tDoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        tDoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = (String) model.get("name");
        toDoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(),
                false);
        return "redirect:list-todos";
    }

}
