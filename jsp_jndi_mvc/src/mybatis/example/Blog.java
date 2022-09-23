package mybatis.example;

/*
id number(11) not null primary key,
title varchar2(100) not null,
writer varchar2(50) not null,
content varchar2(1000)
 */
public class Blog {
   private int id;
   private String title;
   private String writer;
   private String content;
   
   public Blog() {
      this(0,"","","");
   }

   public Blog(int id, String title, String writer, String content) {
      this.id = id;
      this.title = title;
      this.writer = writer;
      this.content = content;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   @Override
   public String toString() {
      return "{\"id\":" + id + ", \"title\":" + title + ", \"writer\":" + writer + ", \"content\":" + content + "}";
   }
}