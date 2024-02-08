package mysql.sec07_bbs.service;

import java.util.List;

import mysql.sec07_bbs.dao.BoardDao;
import mysql.sec07_bbs.dao.ReplyDao;
import mysql.sec07_bbs.entity.Board;
import mysql.sec07_bbs.entity.Reply;

public class BoardServiceMySQLImpl implements BoardService{
	private String sessionUid = "james";	// james로 로그인 하였다고 가정
	// public static final int COUNT_PER_PAGE = 10;	==> 오류발생원인 : BoardService.java 파일 코드와 연관
	private BoardDao bDao = new BoardDao();
	private ReplyDao rDao = new ReplyDao();
	
	@Override
	// 페이지 번호
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		if (field == null || field.equals("")) { 	 // 빈 스트링 또는 null 일 때 title 을 줄 것임
			field = "title"; query = "%";		 // 사실은 query도 wildcard로 줄 것임
		}
		
		List<Board> list = bDao.getBoardList(field, query, COUNT_PER_PAGE, offset);
		return list;
	}
	
	@Override
	public Board getBoard(int bid) {
		Board board = bDao.getBoard(bid);
		if (!board.getUid().equals(sessionUid)) {
			bDao.increaseCount("view", bid);
			board.setViewCount(board.getViewCount() +1);
		}
		List<Reply> list = rDao.getReplyList(bid);		// 이것까지 가져와야 함 - 현재는 리스트를 담아둘 곳 만들어줘야함
		if (list.size() > 0)
			board.setReplyList(list);
		return board;
	}

	@Override
	public void insertBoard(Board board) {
	}

	@Override
	public void updateBoard(Board board) {
	}

	@Override
	public void deleteBoard(int bid) {
	}

	@Override
	public void close() {
	}

}
