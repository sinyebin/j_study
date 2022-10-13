package org.comstudy21.myapp.board;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	private String searchKeyword="";
	private String searchCondition="";
	//1. commons-fileupload 라이브러리 추가 해야 사용 가능.
	//2. CommonsMultipartResolver 빈 생성
	private MultipartFile uploadFile;
	private String fileName="";
	private String uploadLocation="";
	
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	public BoardVO(int seq) {
		this.seq = seq;
	}

}
