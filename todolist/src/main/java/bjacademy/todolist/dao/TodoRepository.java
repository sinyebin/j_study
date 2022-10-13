package bjacademy.todolist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bjacademy.todolist.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	//추가 되는 기능은 추상메소드로 선언한다.
	// JPA는 기본식으로 JQL 사용 - 필드명, 클래스명으로 식별한다.
	//@Query("SELECT t FROM TodoEntity t WHERE t.userId = ?1")
	@Query(value="select * from Todo t where t.user_Id=?1",nativeQuery=true)
	List<TodoEntity> findByUserId(String userId);
}
