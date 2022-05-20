package com.kosta.model;

import java.sql.Date;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	public List<BoardEmpVO> selectAllJoin() {
		return boardDAO.selectAllJoin();
	}
	
	//1.모든게시글조회
	public List<BoardVO> selectAll() {
		return boardDAO.selectAll();
	}
	
	//2.작성자로 조회
	public List<BoardVO> selectByWriter(int writer) {
		return boardDAO.selectByWriter(writer);
	}
	
	//3.게시물번호로조회
	public BoardVO selectByBno(int bno) {
		return boardDAO.selectByBno(bno);
	}
	
	//4.제목으로 조회
	public List<BoardVO> selectByTitle(String title) {
		return boardDAO.selectByTitle(title);
	}
	
	//5.날짜로 조회
	public List<BoardVO> selectByRegdate(Date sdate, Date edate) {
		return boardDAO.selectByRegdate(sdate, edate);
	}
	
	//6.새로운게시글
	public int newBoard(BoardVO board) {
		return boardDAO.newBoard(board);
	}
	
	//7.게시글수정
	public int updateBoard(BoardVO board, int bno) {
		return boardDAO.updateBoard(board, bno);
	}
	
	//8.게시글삭제
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}
	
	//9. 작성자로 삭제
	public int deleteBoardById(int writer) {
		return boardDAO.deleteBoardById(writer);
	}
}
