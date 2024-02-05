package mysql.sec01_basic.sec02_kcity;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
* city Dao (Data Access Object) -- DB table 을 다루는 라이브러리
*           Select, Insert, Update, Delete 를 처리하는 프로그램
*/
public class CityDao {
	private String connStr;
	private String user;
	private String password;

	public CityDao() {

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

	public City getCityById(int id) {
		Connection conn = myConnection(); // myConnection 입력하면 우리가 만든 class랑 연결됨
		String sql = "select * from kcity where id=?";
		City city = new City(); // 방법 1
		try {
			// try 구문 안에서 파라메터 값 세팅 해줘야 함
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			// 셀렉트 실행하고 결과 받기
			ResultSet rs = pstmt.executeQuery();

			// 실행은 항상 while 사용함
			while (rs.next()) {
				// 받아온 게 없으면 빈껍데기, 받아온 게 있으면 값이 들어갈 것임
				city.setId(rs.getInt(1)); // 받아온 값의 1번째 호출 // 방법1 setter 로 변수값을 지정
				city.setName(rs.getString(2)); // 방법1
				city.setCountryCode(rs.getString(3)); // 방법1
				city.setDistrict(rs.getString(4)); // 방법1
				city.setPopulation(rs.getInt(5)); // 방법1
//				city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), // 방법2 생성자를 이용해서 지정
//						rs.getString(4), rs.getInt(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

	public City getCityByName(String name) {
		Connection conn = myConnection();
		String sql = "select * from kcity where name=?";
		City city = null;
		try {
			// try 구문 안에서 파라메터 값 세팅 해줘야 함
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			// Select 실행하고 결과를 ResultsSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

	public List<City> getCityListAll() {
		Connection conn = myConnection();
		String sql = "select * from kcity";
//		ArrayList 만들어서 list 객체를 여러 개 만들어서 보내줌 
//		=> 데이터 베이스에서 저렇게 쓰기
//		=> loop 안에서 객체 만들어서 매달아 줘야 함
		List<City> list = new ArrayList<City>();
		try {
			Statement stmt = conn.createStatement();
			// Select 실행하고 결과를 ResutSet으로 받기
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 80줄의 데이터가 있는데 while () 문안에서 List <City> 로 들어가야한다 -> 구현객체를 만들어 줘야함-->
				// ArrayList를 미리 만들어 놓아야 함
				City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(city);
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

	public List<City> getCityListByDistrict(String district) {
		Connection conn = myConnection();
		String sql = "select * from kcity where district=?";
		List<City> list = new ArrayList<>();
		try {
			// 파라메터 세팅하기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, district);
			// Select 실행하고 결과를 ResutSet으로 받기
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(city);
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

//		public void updateCity(City city) {		// 2번째 수정 : insertCity 에서 updateCity 로 변경 / 3번쨰 수정 : deleteCity
//			Connection conn = myConnection();
//			String sql = "update kcity set name=?, countrycode=?, district=?, population=? where id=?";		// 2번째 수정 : update 시 추가됨
//			String sql = "insert into kcity values(default, ?, ?, ?, ?)";									// 둘 중 하나만 쓰기
//			try {
//				// 파라메터 세팅하기
//				PreparedStatement pstmt = conn.prepareStatement(sql);		// parameter setting processing
//				pstmt.setString(1, city.getName());		//  getter setter 값을 어디에 넣어줄 것인지를 잘 판단해야함
//				pstmt.setString(2, city.getCountryCode());
//				pstmt.setString(3, city.getDistrict());
//				pstmt.setInt(4, city.getPopulation());		// 전부 다 객체임 객체 클래스를 달고 살아야 함 => 개념을 확실하게 가져가기
//				pstmt.setInt(5, city.getId());
//				// Select 실행할 필요없고 / 결과를 ResultSet으로 받을 필요없음 / void 니까 리턴값도 필요없음
//				// SQL 실행
//				pstmt.executeUpdate(); // executeUpdate만 쓰면되고
//				pstmt.close(); // 이거랑
//				conn.close();	// 이거만 넣어주면 됨			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
	public void deleteCity(int id) { // 2번째 수정 : insertCity 에서 updateCity 로 변경 / 3번쨰 수정 : deleteCity
		Connection conn = myConnection();
		String sql = "delete from kcity where id=?"; // 3번째 수정 : delete 시 추가됨
		try {
			// 파라메터 세팅하기
			PreparedStatement pstmt = conn.prepareStatement(sql); // parameter setting processing
			pstmt.setInt(1, id);

			// SQL 실행
			pstmt.executeUpdate(); // executeUpdate만 쓰면 됨
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}