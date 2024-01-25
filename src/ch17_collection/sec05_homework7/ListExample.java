package ch17_collection.sec05_homework7;

public class ListExample {

	public static void main(String[] args) {
		BoardDao dao = new new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}

	}

}
