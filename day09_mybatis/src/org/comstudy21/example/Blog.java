package org.comstudy21.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
	// bno,title,writer,regDate
	private int bno;
	private String title;
	private String writer;
	private String regDate;
}
