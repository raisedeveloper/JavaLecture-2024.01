package mysql.sec01_basic.sec02_homework;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		SongDao songDao = new SongDao(); // SongDao 는 동작(서비스)단임 / 밑에 Song이 VO임
		Song song = songDao.getSongBySid(101);
		System.out.println(song);
		song = null;
		song = songDao.getSongByTitle("Tell Me");

		System.out.println("=================================================================================");

		List<Song> list = songDao.getSongListAll();
		// list.add(songDao.getSongByTitle("Tell Me"));
		list.forEach(x -> System.out.println(x));

		// 여기까지는 Select 만 한것임
		// 이하 부터는 insert update delete 할 것임

		song = new Song("혜성", "어두운 하늘을 날아다니는 저 빛나는 별을 타고서");
		songDao.insertSong(song);

		// insert 수정 시 추가된 항목 이하 4줄
		song.setTitle("혜성");
		songDao.updateSong(song);

		songDao.deleteSong(116);

		list = songDao.getSongListByLyrics("tell me tell me tetetete tel me");
		list.forEach(x -> System.out.println(x));
	}

}
