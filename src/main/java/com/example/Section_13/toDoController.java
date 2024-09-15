package com.example.Section_13;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class toDoController {

    private toDoService tDoService;

    public toDoController(toDoService tDoService) {
        super();
        this.tDoService = tDoService;
    }

    // => url
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = tDoService.findByUserName("reyansh");
        model.addAttribute("todos", todos);
        return "list";
    }

    // GET , POST

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        // We are creating by default for the to do
        Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    /*
     * 
     * @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
     * public String addTodos() {
     * return "todo";
     * }
     * Handling post method
     * 
     * @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
     * public String addNewTodo(@RequestParam String description, ModelMap
     * model,Todo
     * todo) {
     * toDoService.addTodo((String) model.get("name"), description,
     * LocalDate.now().plusYears(1), false);
     * // This is the path name where we are redirecting
     * return "redirect:list-todos";
     * }
     */

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, Todo todo) {
        toDoService.addTodo((String) model.get("name"), (String) todo.getDescription(), LocalDate.now().plusYears(1),
                false);
        // This is the path name where we are redirecting
        return "redirect:list-todos";
    }

}
