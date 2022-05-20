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
	
	//1.���Խñ���ȸ
	public List<BoardVO> selectAll() {
		return boardDAO.selectAll();
	}
	
	//2.�ۼ��ڷ� ��ȸ
	public List<BoardVO> selectByWriter(int writer) {
		return boardDAO.selectByWriter(writer);
	}
	
	//3.�Խù���ȣ����ȸ
	public BoardVO selectByBno(int bno) {
		return boardDAO.selectByBno(bno);
	}
	
	//4.�������� ��ȸ
	public List<BoardVO> selectByTitle(String title) {
		return boardDAO.selectByTitle(title);
	}
	
	//5.��¥�� ��ȸ
	public List<BoardVO> selectByRegdate(Date sdate, Date edate) {
		return boardDAO.selectByRegdate(sdate, edate);
	}
	
	//6.���ο�Խñ�
	public int newBoard(BoardVO board) {
		return boardDAO.newBoard(board);
	}
	
	//7.�Խñۼ���
	public int updateBoard(BoardVO board, int bno) {
		return boardDAO.updateBoard(board, bno);
	}
	
	//8.�Խñۻ���
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}
	
	//9. �ۼ��ڷ� ����
	public int deleteBoardById(int writer) {
		return boardDAO.deleteBoardById(writer);
	}
}
