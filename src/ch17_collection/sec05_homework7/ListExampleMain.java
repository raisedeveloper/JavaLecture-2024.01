package ch17_collection.sec05_homework7;

import java.util.List;

public class ListExampleMain {

	public static void main(String[] args) {
		boardDao dao = new boardDao();
		List<Board> list = dao.getBoardList();
		for (Board board : list)
			System.out.println(board.getTitle() + "-" + board.getContent());
	}

}
