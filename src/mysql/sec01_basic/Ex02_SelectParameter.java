package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02_SelectParameter {

	public static void main(String[] args) {
		select("KOR", 10);
	}
	
	static void select(String countryCode, int num) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world", "hmuser", "hmpass"
					);
			String sql = "select * from city where countrycode=? limit ?";
			
		// SQL에 파라메터 셋팅 -- 중요
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, countryCode);
			pstmt.setInt(2, num);
			
			// Select 실행후 결과를 resultSet에 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1); // rs.getInt("ID") 칼럼이름 ID 해도 같은 값 도출
				String name = rs.getString(2);
				countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				System.out.println(id + ", " + name + ", " + countryCode + ", " + district + ", " + population);
			}
			
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
