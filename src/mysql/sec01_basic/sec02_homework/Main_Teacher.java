package mysql.sec01_basic.sec02_homework;

import java.util.List;

public class Main_Teacher {

	public static void main(String[] args) {
		SongDao songDao = new SongDao(); // SongDao 는 동작(서비스)단임 / 밑에 Song이 VO임
		
		Song song = songDao.getSongById(101);
		System.out.println(song);
		
		song = songDao.getSongByTitle("별빛");
		System.out.println(song);
		System.out.println("=================================================================================");
		
//		song = new Song("Hypeboy", "하 하 하 하입보이");	// insert 함 / Sid가 없는 생성자 만들어야 error X
//		songDao.updateSong(song);

		song = songDao.getSongBySid(117);
		song.setLyrics("너 없이는 매일 매일이 yeah 재미없어 어쩌지");
		songDao.updateSong(song);
		
		songDao.deleteSong(118);
		
		List<Song> list = songDao.getSongListAll();
		list.forEach(x -> System.out.println(x));
		
	}

}