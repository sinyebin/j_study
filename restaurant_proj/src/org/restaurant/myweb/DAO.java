package org.restaurant.myweb;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	// selectAll,insert,update,delete, selectOne
	public List<Object> selectAll()throws SQLException;

	public Object selectOne(int no)throws SQLException;

	public void insert(Object obj)throws SQLException;

	public void update(Object obj)throws SQLException;

	public void delete(int no)throws SQLException;
}
