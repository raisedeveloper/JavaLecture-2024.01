package mysql.sec01_basic.sec02_kcity;

public class CityProject { }
	/* 	-- MySQL world database에 있는 테이블을 활용해서 다음 문항에 답하세요. --

			1) 국내 광역시도별 도시의 개수가 많은 5개 광역시도를 조회하는 SQL.

			2) 인구수가 800만 보다 큰 도시의 국가명, 도시명, 인구수를 조회하는 SQL.

			3) 아시아 대륙에서 인구수가 가장 많은 도시 Top 10을 조회하는 SQL
			(국가명, 도시명, 인구수)

			4) 강원도(Kang-won)에 인구가 120000인 태백시를 삽입하는 SQL.

			5) Chunchon 시의 이름과 인구수를 춘천과 30만으로 변경하는 SQL. */
/*		
1) 
SELECT District, count(District) FROM city 
WHERE CountryCode='KOR'
GROUP BY District
ORDER BY COUNT(District) DESC
LIMIT 5;

2)
SELECT country.name, city.name, city.population 
FROM city JOIN country 
where city.population > 8000000

3)
SELECT country.name, city.name, city.population 
FROM city JOIN country 
where country.continent = 'Asia'
ORDER BY city.population desc
LIMIT 10;

4)
INSERT INTO city(NAME, countrycode, district, population) VALUES('태백시', 'KOR', 'Kang-won', 120000)

5)
UPDATE kcity SET name='춘천', population=300000 WHERE id=2365

1) DTO City 
	import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CityDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public CityDao() {
        String path = "C:/Workspace/WebProject/05. JAVA/Back_End_JAVA_Lecture/src/MySQL/sec05_basic/mysql.properties";
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(path));

            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String database = prop.getProperty("database");

            this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
            this.conn = DriverManager.getConnection(connStr, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public City getCity(int id) {
        String sql = "select * from city where id = ?";
        City city = new City();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    // field는 table의 컬럼명, query는 검색어, num과 offset은 각각 limit와 offset 값
    public List<City> getCityList(String field, String query, int num, int offset) {
        String sql = "select * from city where " + field + " Like ? "
                + " order by Population desc, id "
                + " limit ? offset ?";
        List<City> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + query + "%");
            pstmt.setInt(2, num);
            pstmt.setInt(3, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insertCity(City city) {
        String sql = "insert into city values(default, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCity(City city) {
        String sql = "update city set name=?, countrycode=?, district=?, population=? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());
            pstmt.setInt(5, city.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCity(int id) {
        String sql = "delete from city where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


2) DAO CityDao 
	import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CityDao {
    private String connStr;
    private String user;
    private String password;
    private Connection conn;

    public CityDao() {
        String path = "C:/Workspace/WebProject/05. JAVA/Back_End_JAVA_Lecture/src/MySQL/mysql.properties";
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(path));

            String host = prop.getProperty("host");
            String port = prop.getProperty("port");
            String database = prop.getProperty("database");

            this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
            this.conn = DriverManager.getConnection(connStr, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public City getCity(int id) {
        String sql = "select * from city where id = ?";
        City city = new City();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    // field는 table의 컬럼명, query는 검색어, num과 offset은 각각 limit와 offset 값
    public List<City> getCityList(String field, String query, int num, int offset) {
        String sql = "select * from city where " + field + " Like ? "
                + " order by Population desc, id "
                + " limit ? offset ?";
        List<City> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + query + "%");
            pstmt.setInt(2, num);
            pstmt.setInt(3, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertCity(City city) {
        String sql = "insert into city values(default, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCity(City city) {
        String sql = "update city set name=?, countrycode=?, district=?, population=? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());
            pstmt.setInt(5, city.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCity(int id) {
        String sql = "delete from city where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/