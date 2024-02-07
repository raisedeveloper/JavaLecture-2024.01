package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageDao {
	private String connStr;
	private String user;
	private String password;
	private Connection conn;
	
public MessageDao() {
	String path = "C:/Workspace/Java/lesson/src/mysql/mysql.properties";
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

	public Message getMessageByMid(int mid) {
		String sql = "select * from message where mid=?"
		Message msg = new Message();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				msg.setMid(rs.getInt(1));
				msg.setContent(rs.getString(2));
				msg.setWriter(rs.getString(3));
				String modTime = rs.getString(4);		// 2024-02-06 16:45:00
				System.out.println(modTime);
				msg.setModTime(LocalDateTime.parse(modTime.replace(" ", "T")));
				msg.setIsDeleted(rs.getInt(5));
			}
			rs.close(); pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();		
			}
	}
	public List<Message> getMessageListByMid(String writer) {
		String sql = "select * from message where writer like ? and isDeleted=0";
		List<Message> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);		// 60 ~ 63번 줄은 기계적으로 작성하기!
			pstmt.setString(1, writer);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next());
			Message m = new Message(rs.getInt(1), rs.getString(2), 
					rs.getString(3), LocalDateTime.parse(rs.getString(4).replace(" ", "T"), 0);
			list.add(m);
			
			rs.close(); 
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertMessage(Message msg) {
		String sql = "insert into message values (default, ?, ?, default, default)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			
			pstmt.executeUpdate();
			pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
		}

	}
	public void updateMessage(Message msg) {
		String sql = "update message set content=?, writer=?, modTime=now() where mid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, msg.getContent());
			pstmt.setString(2, msg.getWriter());
			pstmt.setInt(3, msg.getMid());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteMessage(int mid) {
		String sql = "update message set content=?, writer=?, modTime=now() where mid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
