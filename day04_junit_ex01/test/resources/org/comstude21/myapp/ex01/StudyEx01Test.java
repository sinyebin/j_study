package org.comstude21.myapp.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudyEx01Test {
	   @BeforeAll
	   static void setUpBeforeClass() throws Exception {
	      System.out.println("1. BeforeAll");
	   }

	   @AfterAll
	   static void tearDownAfterClass() throws Exception {
	      System.out.println("5. AfterAll()");
	   }

	   @BeforeEach
	   void setUp() throws Exception {
	      System.out.println("2. BeforeEach()");
	   }

	   @AfterEach
	   void tearDown() throws Exception {
		   System.out.println("4. AfterEach");
	   }

	   @Test
	   void test() {
	      System.out.println("3. test");
	   }

}
