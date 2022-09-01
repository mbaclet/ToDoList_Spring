package fr.m2i.tp_todolist.repositories;

import fr.m2i.tp_todolist.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
