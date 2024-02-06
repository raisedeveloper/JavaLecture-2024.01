package mysql.sec04_girl_group;

import java.awt.GridBagLayout;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.prefs.PreferenceChangeEvent;

public class GirlGroupDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;	// connection 과 conn.close();가 필요없어짐 단, 불편한 경우 생김 : Dao 를 죽일 때 close를 쓸 수 없게 됨 

	public void GirlGroupDao() {

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
			e.printStackTrace(); // printStackTrace : notice about error information
		}
	}

	public void close() {
	
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public GirlGroup getGirlGroupByGid(int gid) {
		String sql = "select * from girl_group where gid=?";
		GirlGroup gg = new GirlGroup();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));
				// LocalDate 로 gg에 LocalDate 타입이 들어가야 함 보통 스트링으로 뽑아내면 rs.getString (3) 하면 나옴
				//gg.setDebut(LocalDate)
				String debutStr = rs.getString(3);	// yyyy-mm-dd
				gg.setDebut(LocalDate.parse(debutStr));
				
				// gg.setDebut(debutStr); LocalDate와 형식이 달라 SetDebut 에 에러남
				// 날짜를 불러오는 방법 위의 두 줄(60, 61)이 반드시 쓰여야 함
				// 날짜와 시간을 모두 쓰려면 방법이 달라짐 => 
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gg;
	}
	
	public GirlGroup getGirlGroupByName(String name) {
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l\r\n"
				+ " JOIN song r ON l.hit_song_id=r.sid"
				+ " WHERE l.name LIKE ?";
		GirlGroup gg = new GirlGroup();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gg.setGid(rs.getInt(1));
				gg.setName(rs.getString(2));
				// LocalDate 로 gg에 LocalDate 타입이 들어가야 함 보통 스트링으로 뽑아내면 rs.getString (3) 하면 나옴
				//gg.setDebut(LocalDate)
				String debutStr = rs.getString(3);	// yyyy-mm-dd
				gg.setDebut(LocalDate.parse(debutStr));
				gg.setHitSongId(rs.getInt(4));
			}
			rs.close(); pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gg;
	}
		
	public List<GirlGroup> getGirlGroupByDebut(int fromYear, int toYear) {
		String sql = "SELECT l.gid, l.name, l.debut, r.title FROM girl_group l\r\n"
				+ "	JOIN song r ON l.hit_song_id=r.sid\r\n"
				+ "	WHERE l.debut BETWEEN ? AND ?"
				+ " ORDER BY l.debut"; // debut 날짜별로 순서배치하는 방법
		List<GirlGroup> list = new ArrayList<GirlGroup>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fromYear + "-01-01" );
			pstmt.setString(2, toYear + "-12-31" );
			
			ResultSet rs =pstmt.executeQuery();
			while (rs.next()) {
				GirlGroup gg = new GirlGroup(rs.getInt(1), rs.getString(2), 
						LocalDate.parse(rs.getString(3)), rs.getInt(4));	
				
				list.add(gg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertGirlGroup (GirlGroup gg) {	// insert -> update 수정
		String sql = "insert into girl_group values(default, ?, ?, ?)";		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString());
			pstmt.setInt(3, gg.getHitSongId());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateGirlGroup (GirlGroup gg) {	// insert -> update 수정
		String sql = "update girl_group set name=?, debut=?, hit_song_id=? where gid=?";		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gg.getName());
			pstmt.setString(2, gg.getDebut().toString());
			pstmt.setInt(3, gg.getHitSongId());
			pstmt.setInt(4, gg.getGid());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteGirlGroup (int gid) {	// insert -> update 수정
		String sql = "delete from girl_group where gid=?";		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	
}



