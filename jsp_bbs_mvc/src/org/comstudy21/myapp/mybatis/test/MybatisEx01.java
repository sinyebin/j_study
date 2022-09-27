package org.comstudy21.myapp.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.comstudy21.myapp.blog.BlogDTO;

public class MybatisEx01 {
	 public static void main(String[] args) throws IOException {
	      String resource = "mybatis-config.xml";
	      InputStream inputStream = Resources.getResourceAsStream(resource);
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	      try (SqlSession session = sqlSessionFactory.openSession()) {
	        BlogDTO blog = session.selectOne("BlogMapper.selectBlog", 1);
	        System.out.println(blog);
	      }
	   }

	
	
	
}
