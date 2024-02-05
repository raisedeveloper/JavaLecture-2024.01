package mysql.sec01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_Select {

	public static void main(String[] args) {
		Connection conn = null; // ctrl+space 하고 Java.sql interface 를 선택
		Statement stmt = null; 
		try {					// ctrl+space 하고 catch 선택
			conn = DriverManager.getConnection(				//  ctrl+space
					"jdbc:mysql://localhost:3306/world",	// 호스트, 포트, DB명 우리가 쓰는 포트가 3306임	// jdbc:mysql 프로토콜임 localhost 를 가지고 있는 그 번호가 3306임
					"hmuser", "hmpass"						// 사용자 이름, 패스워드
					);
			stmt = conn.createStatement();
			String sql = "select * from city where countrycode='KOR' limit 10";
			
			// Select 실행 - 결과는 result set 사용
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1); // rs.getInt("ID") 칼럼이름 ID 해도 같은 값 도출
				String name = rs.getString(2);
				String countryCode = rs.getString(3);
				String district = rs.getString(4);
				int population = rs.getInt(5);
				System.out.println(id + ", " + name + ", " + countryCode + ", " + district + ", " + population);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();					//  ctrl+space
		}
	}

}
