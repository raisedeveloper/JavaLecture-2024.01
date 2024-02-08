package mysql.sec07_bbs.dao;

import java.util.List;

import mysql.sec07_bbs.entity.Board;

public class BoardDaoTest {

	public static void main(String[] args) {
		BoardDao bDao = new BoardDao();
		String sessionUid = "james";		// james 의 로그인 상황 가정		
		Board b = bDao.getBoard(12);		
		if (!b.getUid().equals(sessionUid))	// james 의 작성글 아닐 시에만 조회수 +1 올려줌
		bDao.increaseCount("view", 12);		// 10번 컨텐츠를 읽고 조회수를 하나 늘릴 때 increaseCount( , );
//		System.out.println(b);
//		 b = new Board("제목 2", "본문 2", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 3", "본문 3", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 4", "본문 4", "maria");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 5", "본문 5", "sarah");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 6", "본문 6", "brian");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 7", "본문 7", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 8", "본문 8", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 9", "본문 9", "maria");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 10", "본문 10", "sarah");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 11", "본문 11", "brian");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 12", "본문 12", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 13", "본문 13", "james");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 14", "본문 14", "maria");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 15", "본문 15", "sarah");
//	        bDao.insertBoard(b);
//	        b = new Board("제목 16", "본문 16", "brian");
//	        bDao.insertBoard(b);
//
//		b = new Board("제목 17", "본문 17", "james");
//		bDao.insertBoard(b);
//		b = new Board("제목 18", "본문 18", "maria");
//		bDao.insertBoard(b);
//		b = new Board("제목 19", "본문 19", "sarah");
//		bDao.insertBoard(b);
//		b = new Board("제목 20", "본문 20", "brian");
//		bDao.insertBoard(b);
//	
	    // 전체 확인
        List<Board> list = bDao.getBoardList("title", "%", 10, 0);
        list.forEach(x -> System.out.println(x.listForm()));
        System.out.println("=======================================================");
        list = bDao.getBoardList("b.uid", "james", 10, 0);
        list.forEach(x -> System.out.println(x.listForm()));
        System.out.println("=======================================================");
        list = bDao.getBoardList("uname", "마리아", 10, 0);
        list.forEach(x -> System.out.println(x.listForm()));
        System.out.println("=======================================================");
        bDao.close();

	}
}
