package fr.m2i.tp_todolist.controllers;

import fr.m2i.tp_todolist.models.ToDo;
import fr.m2i.tp_todolist.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ToDoListController {

    @Autowired
    private ToDoService tds;

    @GetMapping("/todos")
    public Iterable<ToDo> getToDos(){
        return tds.getTodos();
    }

    @PostMapping("/todo")
    public ToDo createTodo(@RequestBody ToDo todo) {
        return tds.saveTodo(todo);
    }

    @GetMapping("/todo/{id}")
    public ToDo getTodo(@PathVariable("id") final Long id) {
        Optional<ToDo> todo = tds.getTodo(id);
        if(todo.isPresent()) {
            return todo.get();
        } else {
            return null;
        }
    }

    @PutMapping("/todo/{id}")
    public ToDo updateTodo(@PathVariable("id") final Long id, @RequestBody ToDo todo) {
        Optional<ToDo> e = tds.getTodo(id);
        if(e.isPresent()) {
            ToDo currentToDo = e.get();

            String firstName = todo.getTitle();
            if(firstName != null) {
                currentToDo.setTitle(firstName);
            }
            String lastName = todo.getDescription();
            if(lastName != null) {
                currentToDo.setDescription(lastName);;
            }
            tds.saveTodo(currentToDo);
            return currentToDo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable("id") final Long id) {
        tds.deleteTodo(id);
    }
}
