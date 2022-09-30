package org.proj.myapp.board;

import org.proj.myapp.board.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	private int num;
	private String author;
	private String email;
	private String title;
	private String content;
	private String passwd;
	private String writeday;
}
