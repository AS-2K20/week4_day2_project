package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
		
	}
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
		Properties prop = null;
		prop = loadPropertiesFile();
		
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		
		Class.forName(driver);
		
		Connection con = null;
		
		con = DriverManager.getConnection(url);
		
		if(con!=null) {
			return con;
		}
		else {
			return null;
		}
		
	}
}


