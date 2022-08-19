package org.comstude21.myapp.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SimpleCalculatorTest {
	SimpleCalculator calc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc = new SimpleCalculator();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("더하기 기능 테스트")
	void test_Add() {
		System.out.println("calc.add(1, 2) ==> "+calc.add(1, 2));
		int result=calc.add(1, 2);
		assertAll( //여러개 검사하고 싶을때 사용
				() -> assertEquals(3, calc.add(1, 2)),
				() -> assertTrue(result>0)
		);
		System.out.println("더하기 다음 기능");
		
	}

	@Test
	@DisplayName("빼기 기능 테스트")
	void test_Sub() {
		System.out.println("빼기");
	}

	@Test
	@DisplayName("곱하기 기능 테스트")
	void test_Mul() {
		System.out.println("곱하기");
	}

	@Test
	@DisplayName("나누기 기능 테스트")
	void test_Div() {
		System.out.println("나누기");
	}

}
