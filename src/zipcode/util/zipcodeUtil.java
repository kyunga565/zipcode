package zipcode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class zipcodeUtil {
	private static final zipcodeUtil instance = new zipcodeUtil();

	public static Connection getInstance() {
		return instance.getConnection();
	}
	
	private zipcodeUtil(){}
	
	public static Connection getConnection(){
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/zipcode";
		String user = "user_zipcode";
		String password = "rootroot";
		
		try {
			connection = (Connection) DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.err.println("확인  ");
			e.printStackTrace();
		}
		
		return connection;
	}
}
