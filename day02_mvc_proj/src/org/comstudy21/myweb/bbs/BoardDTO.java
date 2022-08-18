package org.comstudy21.myweb.bbs;

public class BoardDTO {
	int no;
	String title;
	String content;
	
	public BoardDTO() {
		
	}
	
	public BoardDTO(int no, String title,String content){
		this.no=no;
		this.title=title;
		this.content=content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
	
}
