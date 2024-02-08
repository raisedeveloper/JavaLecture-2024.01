package mysql.sec07_bbs.dao;

import java.util.List;

import mysql.sec07_bbs.entity.Reply;

public class ReplyDaoTest {

	public static void main(String[] args) {
		ReplyDao rDao = new ReplyDao();
		BoardDao bDao = new BoardDao();
		String sessionUid = "maria";
		int bid = 12;
		
		Reply r = new Reply();
		r.setComment("댓글 2"); r.setUid(sessionUid); r.setBid(bid);
		rDao.insertReply(r);
		bDao.increaseCount("reply", bid);
		
		List<Reply> list = rDao.getReplyList(bid);
		list.forEach(x -> System.out.println(x));
		
		bDao.close(); rDao.close();
	}
}
