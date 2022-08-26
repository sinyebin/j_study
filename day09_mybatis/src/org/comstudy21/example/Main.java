package org.comstudy21.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

   public static void main(String[] args) throws IOException {
      String resource = "org/comstudy21/example/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      
      try (SqlSession mybatis = sqlSessionFactory.openSession()) {
        Blog blog = mybatis.selectOne("BlogMapper.selectBlog", 101);
        System.out.println(blog);
        System.out.println();
        
       // List<Blog> list = mybatis.selectList("BlogMapper.selectAll");
      }
   }

}