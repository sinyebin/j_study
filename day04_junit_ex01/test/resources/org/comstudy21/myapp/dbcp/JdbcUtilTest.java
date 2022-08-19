package org.comstudy21.myapp.dbcp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JdbcUtilTest {
	Connection conn = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		conn = JdbcUtil.getConnection();
	}

	@AfterEach
	void tearDown() throws Exception {
		JdbcUtil.close(conn);
	}

	@Test
	@DisplayName("connection 객채 생성 test")
	void testGetConnection() {
		assertNotNull(conn, "conn은 null이 아니어야 합니다.");

	}

	@Test
	@Disabled
	void testCloseConnectionStatementResultSet() {
		assertEquals(1, JdbcUtil.close(conn));
	}

}
