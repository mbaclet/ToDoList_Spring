package fr.m2i.tp_todolist.services;

import fr.m2i.tp_todolist.models.ToDo;
import fr.m2i.tp_todolist.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository tdr;

    public Optional<ToDo> getTodo(final Long id) {
        return tdr.findById(id);
    }

    public Iterable<ToDo> getTodos() {
        return tdr.findAll();
    }

    public void deleteTodo(final Long id) {
        tdr.deleteById(id);
    }

    public ToDo saveTodo(ToDo employee) {
        ToDo save = tdr.save(employee);
        return save;
    }
}
