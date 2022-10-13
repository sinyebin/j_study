package bjacademy.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bjacademy.todolist.model.TodoEntity;
import bjacademy.todolist.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	TodoService service;
	
	@GetMapping("/list")
	public List<TodoEntity> list() {
		List<TodoEntity> todoList = service.selectAll();
		return todoList;
	}
	
	@GetMapping("/input")
	public List<TodoEntity> input(@RequestBody(required=true) TodoEntity entity) {
		service.create(entity);
		return service.selectAll();
	}
	
	@GetMapping("/update")
	public List<TodoEntity> update(@RequestBody(required=true) TodoEntity entity) {
		service.update(entity);
		return service.selectAll();
	}
	
	@GetMapping("/delete")
	public List<TodoEntity> delete(@RequestBody(required=true) TodoEntity entity) {
		service.delete(entity);
		return service.selectAll();
	}
	
	@GetMapping("/find")
	public List<TodoEntity> find(@RequestBody(required=true) TodoEntity entity) {
		
		return service.retrieve(entity.getUserId());
	}
	
}
