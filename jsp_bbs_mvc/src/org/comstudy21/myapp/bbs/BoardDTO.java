package org.comstudy21.myapp.bbs;
/*
  	num number not null primary key,
	author varchar2(100) not null,
	email varchar2(200) not null,
	title varchar2(500) not null,
	content varchar2(4000) not null,
	passwd varchar2(12) not null,
	writeday date,
	readcnt number,
	rep_root number,
	rep_step number,
	rep_indent number
 */
public class BoardDTO {
	private int num;
	private String author;
	private String email;
	private String title;
	private String content;
	private String passwd;
	private String writeday;

	
	public BoardDTO(int num, String author, String email, String title, String content, String passwd, String writeday) {
		this.num=num;
		this.author=author;
		this.email=email;
		this.title=title;
		this.content=content;
		this.passwd=passwd;
		this.writeday=writeday;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String toString() {
	      return "{\"num\":" + num + ", \"title\":" + title + ", \"author\":" + author + ", \"content\":" + content + ", \"email\":" + email+", \"passwd\":" + passwd +", \"writeday\":" + writeday +"}";
	   }
	
}
