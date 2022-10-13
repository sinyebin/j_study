package org.comstudy21.myapp;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.comstudy21.myapp.board.BoardService;
import org.comstudy21.myapp.board.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("board")
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	BoardService boardService;

	public ModelAndView getBoardModel(String viewName, BoardVO vo, ModelAndView mav) {
		BoardVO board = boardService.getBoard(vo);
		mav.addObject("board", board);
		mav.setViewName(viewName);

		return mav;
	}

	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav,BoardVO vo) {
		System.out.println(vo);
		List<BoardVO> list = boardService.getBoardList(vo);
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}

	@RequestMapping("/detail")
	public ModelAndView detail(BoardVO vo, ModelAndView mav) {
		 return getBoardModel("board/detail", vo, mav);
	}

	@RequestMapping("/delete")
	public ModelAndView delete(BoardVO vo, ModelAndView mav) {
		System.out.println(vo);
		logger.info(vo.toString());
		boardService.deleteBoard(vo);
		mav.setViewName("redirect:/board/list");
		return mav;
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(BoardVO vo, ModelAndView mav) {
		return "board/input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public ModelAndView input1(BoardVO vo, ModelAndView mav) throws IllegalStateException, IOException {
		// 파일 저장 경로 및 업로드 처리
		MultipartFile uploadFile=vo.getUploadFile();
		String uploadLocation = "E:/j_proj/j_study/StsBoardEx04/src/main/webapp/resources/upload/";
		if(!uploadFile.isEmpty()) {
			String fileName=uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadLocation+fileName));
			vo.setFileName(fileName);
			vo.setUploadLocation(uploadLocation);
		}
		boardService.insertBoard(vo);
		mav.setViewName("redirect:/board/list");
		return mav;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modify(BoardVO vo, ModelAndView mav) {
		return getBoardModel("board/modify", vo, mav);

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify1(BoardVO vo, ModelAndView mav) {
		boardService.updateBoard(vo);
		mav.setViewName("redirect:/board/list");
		return mav;
	}
}
