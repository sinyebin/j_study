package org.comstudy21.myapp.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private int seq;
	private String title;
	private String writer;
	private String Content;
	private String regDate;
	private int cnt;
}
