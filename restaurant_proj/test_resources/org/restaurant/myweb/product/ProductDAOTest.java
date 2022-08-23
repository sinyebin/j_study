package org.restaurant.myweb.product;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductDAOTest {
	ProductDAO dao = null;
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
	void testSelectAll() throws SQLException {
		List<Object> list = dao.selectAll();
		assertTrue(list.size() > 0);
		list.forEach((item) -> System.out.println(item));
	}

	@Test
	void testSelectOne() throws SQLException {
		Object dto = dao.selectOne(105);
		System.out.println(dto);
	}


	
}
