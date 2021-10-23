package main;

import ResponsObjects.ToDo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ToDoController {

    @GetMapping("/things/")
    public Map map() {
        return Storage.getAllThings();
    }

    @PostMapping("/things/")
    public int toDo(ToDo toDo) {
        return Storage.addToDo(toDo);
    }

    @GetMapping("/things/{id}")
    public ResponseEntity get(@PathVariable int id) {
        if (Storage.getToDo(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена");
        }
        return new ResponseEntity(Storage.getToDo(id), HttpStatus.OK);
    }

    @DeleteMapping("/things/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (Storage.getToDo(id) != null || Storage.getAllThings().containsKey(id)) {
            Storage.deleteToDo(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена");
    }

    @DeleteMapping("/things/")
    public void deleteAll() {
        Storage.getAllThings().clear();
    }

    @PutMapping("/things/{id}")
    public ResponseEntity put(@PathVariable int id, ToDo toDo) {
        if (Storage.getToDo(id) == null || !Storage.getAllThings().containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Задача не найдена");
        }

        Storage.setToDo(id, toDo);

        return new ResponseEntity(Storage.getToDo(id), HttpStatus.OK);
    }

    @PutMapping("/things/")
    public void putAll(ToDo toDo) {
        for (Integer key : Storage.getAllThings().keySet()) {
            ToDo newToDo = new ToDo();
            newToDo.copyToDo(toDo);
            newToDo.setId(key);
            Storage.setToDo(key, newToDo);
        }
    }
}
