package mysql.sec05_message;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
		
		return null;
	}
	
	public List<Message> getmessageListByWriter(String writer) {

	return null;
	}
	public void insertMessage(Message msg) {
		
	}
	public void updateMessage(Message msg) {
		
	}
	public void deleteMessage(Message msg) {
		
	}
	
}
