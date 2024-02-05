package mysql.sec01_basic.sec02_homework;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mysql.sec01_basic.sec02_kcity.City;

/*
* SongDao (Data Access Object) -- DB table 을 다루는 라이브러리
*           Select, Insert, Update, Delete 를 처리하는 프로그램
*/

public class SongDao {
	private String connStr;
	private String user;
	private String password;

	public SongDao() {
// 		만들어야 할 것
//		1. getSongByID
//		2. getSongList
//		3. insert
//		4. update 
//		5. delete

		String path = "C:/workspace/Java/lesson/src/mysql/mysql.properties";
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));

			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String database = prop.getProperty("database");

			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public Connection myConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connStr, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Song getSongById(int sid) {
		Connection conn = myConnection(); // myConnection 입력하면 우리가 만든 class랑 연결됨
		String sql = "select * from song where sid=?";
		Song song = new Song(); // 방법 1
		try {
			// try 구문 안에서 파라메터 값 세팅 해줘야 함
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);

			// 셀렉트 실행하고 결과 받기
			ResultSet rs = pstmt.executeQuery();
			// 실행은 항상 while 사용함
			while (rs.next()) {
				// 받아온 게 없으면 빈껍데기, 받아온 게 있으면 값이 들어갈 것임
				// 받아온 값의 1번째 호출 // 방법1 사용 - setter 로 변수값을 지정
				song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	public Song getSongByTitle(String title) {
		Connection conn = myConnection();
		Song song = new Song();
		String sql = "select * from song where title=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				song.setSid(rs.getInt(1));
				song.setTitle(rs.getString(2));
				song.setLyrics(rs.getString(3));
			}
				rs.close();
				pstmt.close();
				conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;

	}

	public List<Song> getSongListAll() {
		Connection conn = myConnection();
		String sql = "select * from song";
		List<Song> list = new ArrayList<Song>();
		try {
			Statement stmt = conn.createStatement();
			// Select 실행하고 결과를 ResutSet으로 받기
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 80줄의 데이터가 있는데 while () 문안에서 List <City> 로 들어가야한다 -> 구현객체를 만들어 줘야함-->
				// ArrayList를 미리 만들어 놓아야 함
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(song);
			}
			// while 문이 끝나고 나면 close(); 해서 닫아줘야 함
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Song> getSongListByLyrics(String lyrics) {
		Connection conn = myConnection();
		String sql = "select * from song where lyrics=?";
		List<Song> list = new ArrayList<>();
		try {
			// 파라메터 세팅하기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lyrics);
			// Select 실행하고 결과를 ResutSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(song);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 여기까지는 Select Processing 만 한것임

		// 이하 부터는 insert update delete 할 것임
	}

	public void insertSong(Song song) {
		Connection conn = myConnection();
		String sql = "insert into song values(?, ?, ?)";
		try {
			// 파라메터 세팅하기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, song.getSid());
			pstmt.setString(2, song.getTitle());
			pstmt.setString(3, song.getLyrics());
			// Select 실행할 필요없고 / 결과를 ResultSet으로 받을 필요없음 / void 니까 리턴값도 필요없음
			// SQL 실행
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSong(Song song) {
		Connection conn = myConnection();
		String sql = "update song set sid=?, title=?, lyrics=? where sid=?";
		try {
			// 파라메터 세팅
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, song.getSid());
			pstmt.setString(2, song.getTitle());
			pstmt.setString(3, song.getLyrics());
			pstmt.setInt(4, song.getSid());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSong(int sid) { // 2번째 수정 : insertCity 에서 updateCity 로 변경 / 3번쨰 수정 : deleteCity
		Connection conn = myConnection();
		String sql = "delete from song where sid=?"; // 3번째 수정 : delete 시 추가됨
		try {
			// 파라메터 세팅하기
			PreparedStatement pstmt = conn.prepareStatement(sql); // parameter setting processing
			pstmt.setInt(1, sid);

			// SQL 실행
			pstmt.executeUpdate(); // executeUpdate만 쓰면 됨
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
