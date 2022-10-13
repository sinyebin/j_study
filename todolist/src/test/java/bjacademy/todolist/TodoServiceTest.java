package bjacademy.todolist;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bjacademy.todolist.model.TodoEntity;
import bjacademy.todolist.service.TodoService;

@SpringBootTest
public class TodoServiceTest {
	
	 @Autowired
	   TodoService service;

	   @BeforeAll
	   static void setUpBeforeClass() throws Exception {
	   }

	   @AfterAll
	   static void tearDownAfterClass() throws Exception {
	   }

	   @BeforeEach
	   void setUp() throws Exception {
	   }

	   @AfterEach
	   void tearDown() throws Exception {
	   }

	   @Test
	   void testTesetService() {
	      System.out.println(service);
	      String title = service.testService();
	      System.out.println("test => " + title);
	   }
	   
	   @Test
	   void testCreate() {
		   TodoEntity entity = TodoEntity.builder().userId("hihi").title("숙제하기").build();
		   List<TodoEntity> list = service.create(entity);
		   System.out.println(list);
	   }
	   
	   @Test
	   void testSelectAll() {
		   TodoEntity entity = TodoEntity.builder().userId("hihi").title("숙제하기").build();
		   service.create(entity);
		   List<TodoEntity> list = service.selectAll();
		   
		   System.out.println(list);
	   }
	   
	   @Test
	   void testUpdate() {
		   TodoEntity entity = TodoEntity.builder().userId("hihi").title("숙제하기").build();
		   List<TodoEntity> list = service.create(entity);
		   
		   System.out.println(list.size());
		   TodoEntity updateTodo = list.get(0);
		   updateTodo.setTitle("수정함...");
		   list = service.update(updateTodo);
		   System.out.println(list);
	   }
	   
	   @Test
	   void testDelete() {
		   TodoEntity entity = TodoEntity.builder().userId("hihi").title("숙제하기").build();
		   List<TodoEntity> list = service.create(entity);
		   
		   if(list.size()>0) {
			   TodoEntity deleteTodo = list.get(0);
			   list = service.delete(deleteTodo);
			   System.out.println(list);
		   }
	   }
}
