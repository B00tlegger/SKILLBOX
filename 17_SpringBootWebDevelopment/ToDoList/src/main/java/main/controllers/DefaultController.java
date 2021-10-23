package main.controllers;

import main.model.ToDo;
import main.repositoryes.ToDoRepository;
import main.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private ToDoRepository toDoRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<ToDo> events = new ToDoService(toDoRepository).getAll();
        model.addAttribute("events", events);
        model.addAttribute("toDoCount", events.size());
        return "index";
    }

    @RequestMapping(value = {"/things/"})
    public String add(){
        return "redirect:/index";
    }
}
