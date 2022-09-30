package org.comstudy21.myapp.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comstudy21.myapp.board.model.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	private SqlSessionTemplate mybatis;

	private static List<BoardDTO> list_ex = new ArrayList<BoardDTO>();
	static {
		// seq, title, writer, Content, regDate, cnt
		list_ex.add(new BoardDTO(1, "글쓰기 연습", "홍길동", "게시판 글쓰기 연습입니다.", "2022-09-29", 0));
		list_ex.add(new BoardDTO(2, "글쓰기 연습2", "홍길순", "게시판 글쓰기 연습2입니다.", "2022-09-29", 0));
		list_ex.add(new BoardDTO(3, "글쓰기 연습3", "홍길자", "게시판 글쓰기 연습3입니다.", "2022-09-29", 0));
		list_ex.add(new BoardDTO(4, "글쓰기 연습4", "김길자", "게시판 글쓰기 연습4입니다.", "2022-09-29", 0));
	}

	@RequestMapping(value = "/board/list.do")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();

		List<BoardDTO> boardList = mybatis.selectList("BaordMapper.selectAll");

		mav.addObject("boardList", boardList);
		mav.setViewName("board/list");

		return mav;
	}

	public ModelAndView boardList_ex() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("boardList", list_ex);
		mav.setViewName("board/list");

		return mav;
	}

	@RequestMapping(value = "/board/detail.do", method = RequestMethod.GET)
	public ModelAndView boardDetail(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		BoardDTO board = mybatis.selectOne("BoardMapper.selectBoard", seq);
		mav.addObject("board", board);
		return mav;
	}

	public ModelAndView detail_Ex(@RequestParam("seq") int seq) {
		ModelAndView mav = new ModelAndView();
		for (BoardDTO list : list_ex) {
			if (list.getSeq() == seq) {
				mav.addObject("board", list);
				break;
			}
		}

		mav.setViewName("board/detail");
		return mav;
	}

}