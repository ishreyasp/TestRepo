package com.shreyas.assignment;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
	
	public MainApp() {
		
	}

	public boolean auth(String username, String password) throws FileNotFoundException {
		String usr = null,pass = null;
		try {
			Utility util = new Utility();
			util.getConnection();
			Class.forName(util.getDriverName());
			Connection con = DriverManager.getConnection(util.getDatabaseUrl(), util.getName(), util.getPassword());
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/validation", "root", "shreyas");
			
			PreparedStatement pstm = con.prepareStatement("select username, password from validate where username = ? and password = ?");
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			rs.next();
			usr = rs.getString(1);
			pass = rs.getString(2);
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username.equals(usr) && password.equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
