package dao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;
public class UserDAO implements UserDaoInterface{

	
	public int signUp(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		String date = (user.getDate()).toString();
		
		ConnectionManager cm = new ConnectionManager();
		String sql = "INSERT INTO USERSDETAIL(EMAIL,PASSWORD,DATECREATED)VALUES(?,?,?)";
		try {
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		st.setString(1, email);
		st.setString(2, password);
		st.setString(3, date);
		
		st.executeUpdate();
		cm.getConnection().close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	
	public boolean loginUser(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		String sql ="SELECT * FROM USERSDETAILS";
		try {
		ConnectionManager cm = new ConnectionManager();
		Statement st = cm.getConnection().createStatement();
		
		ResultSet resultSet = st.executeQuery(sql);
		
		while(resultSet.next()) {
			if(email.equals(resultSet.getString("EMAIL"))&&(password.equals(resultSet.getString("PASSWORD")))){
				return true;
			}
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
