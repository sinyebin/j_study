package org.comstudy21.myapp.board.impl;

import java.util.List;

import org.comstudy21.myapp.board.BoardService;
import org.comstudy21.myapp.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
   @Autowired
   private BoardDAO boardDAO;
   
   @Override
   public void insertBoard(BoardVO vo) {
//      if(vo.getSeq() <= 0) {
//         System.out.println(">>>>> 0이하의 SEQ는 등록 불가능합니다!");
//         throw new IllegalArgumentException("0이하의 SEQ는 등록 불가능합니다!");
//      }
      boardDAO.insertBoard(vo);
   }

   @Override
   public void updateBoard(BoardVO vo) {
      boardDAO.updateBoard(vo);
   }

   @Override
   public void deleteBoard(BoardVO vo) {
      boardDAO.deleteBoard(vo);
   }

   @Override
   public BoardVO getBoard(BoardVO vo) {
      return boardDAO.getBoard(vo);
   }

   @Override
   public List<BoardVO> getBoardList(BoardVO vo) {
      return boardDAO.getBoardList(vo);
   }
}