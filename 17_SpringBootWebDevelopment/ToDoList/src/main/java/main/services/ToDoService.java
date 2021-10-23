package main.services;

import main.model.ToDo;
import main.repositoryes.ToDoRepository;
import main.dao.Dao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService implements Dao<ToDo> {

    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> getAll() {
        Iterable<ToDo> iterable = toDoRepository.findAll();
        ArrayList things = new ArrayList();
        things.addAll((Collection) iterable);
        return things;
    }

    @Override
    public int add(ToDo toDo) {
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo.getId();
    }

    @Override
    public ToDo get(int id) {
        Optional<ToDo> optional = toDoRepository.findById(id);
        if (!optional.isPresent()) {
            return null;
        }
        return optional.get();
    }

    @Override
    public void delete(int id) {
        if (toDoRepository.findById(id).isPresent()) {
            toDoRepository.deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        toDoRepository.deleteAll();
    }

    @Override
    public ToDo put(ToDo toDo) {
        ToDo newToDo = toDoRepository.save(toDo);
        return newToDo;
    }
}
