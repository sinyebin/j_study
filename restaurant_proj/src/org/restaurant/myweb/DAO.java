package org.restaurant.myweb;

import java.sql.SQLException;
import java.util.List;


public interface DAO<T> {
	// selectAll,insert,update,delete, selectOne
	public List<T> selectAll()throws SQLException;

	public T selectOne(int no)throws SQLException;

	public void insert(T obj)throws SQLException;

	public void update(T obj)throws SQLException;

	public void delete(int no)throws SQLException;


}
