package main.controllers;

import main.model.ToDo;
import main.repositoryes.ToDoRepository;
import main.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private  Dao<ToDo> toDoService;

    @GetMapping("/things/")
    public Iterable<ToDo> list() {
        return toDoService.getAll();
    }

    @PostMapping("/things/")
    public String add(@ModelAttribute ToDo toDo, Model model) {
        toDoService.add(toDo);
        return "redirect:/";
    }

    @GetMapping("/things/{id}")
    public ResponseEntity get(@PathVariable int id) {
        if (toDoService.get(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDoService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/things/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        toDoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/things/")
    public ResponseEntity deleteAll() {
        toDoService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/things/{id}")
    public ResponseEntity put(ToDo toDo) {
        return new ResponseEntity(toDoService.put(toDo), HttpStatus.OK);
    }
}