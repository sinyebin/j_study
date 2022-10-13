package bjacademy.todolist.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bjacademy.todolist.dao.TodoRepository;
import bjacademy.todolist.model.TodoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repository;
	public String testService() {
		TodoEntity entity = TodoEntity.builder().title("밥 먹기").build();
		// 저장 테스트
	    System.out.println(repository);
	    repository.save(entity); // save = insert + update
		//검색 테스트
		TodoEntity todo = repository.findById(entity.getId()).get();
		return "test service >> title: " +todo.getTitle();
	}
	
	public List<TodoEntity> create(final TodoEntity entity){
		
		validate(entity);
		repository.save(entity);
		
		return repository.findByUserId((entity.getUserId()));
	}
	
	private void validate(TodoEntity entity) {
		if(entity==null) {
			String message="Entity cannot be null";
			System.out.println("Entity가 null입니다.");
			log.warn(message);
			throw new RuntimeException(message);
		}
		
		if(entity.getUserId()==null) {
			String message="Unknown user.";
			System.out.println("UserId가 null입니다.");
			log.warn(message);
			throw new RuntimeException(message);
		}
	}
	 public List<TodoEntity> selectAll() {
	      return repository.findAll();
	   }

	
	public List<TodoEntity> selectById(final String userId){
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> update(final TodoEntity entity){
		// save = insert + update
		repository.save(entity);
		return retrieve(entity.getId());
	}
	
	public List<TodoEntity> delete(final TodoEntity entity){
		// save = insert + update
		try {
			repository.delete(entity);
		}catch(Exception e){
			String message="error delete.";
			System.out.println("삭제 시 오류 발생.");
			log.warn(message);
			throw new RuntimeException(message);
		}
		
		return retrieve(entity.getUserId());
	}
	
}
