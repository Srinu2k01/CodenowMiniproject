package com.cmr.prj.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cmr.prj.util.DBConnection;
public class LoginRepository {
public String getPassword(String userName) {
		
		Connection con = DBConnection.getConnection();
		String password = "  *   ";
		
		
		try {
			// Step 3:
			final String SQLQUERY = "select password from login where username=?";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			
			// step 4:
			
			// Step 4.1 ---> Inject the value of ? to prepared statement query
			pstmt.setString(1, userName);
			
			// Step 4.2 ---> call executeQuery()
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Statement executed successfully.......");

			// Step 5: 
			while(rs.next()) {
				password = rs.getString("password");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(password);
		return password;
		
		
	}
	
	
	public int registerUser(String userName,String password) {
		
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		
		try {
			// Step 3:
			final String SQLQUERY = "insert into login values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			
			// step 4:
			
			// Step 4.1 ---> Inject the value of ? to prepared statement query
			pstmt.setString(1, userName);
			pstmt.setString(2,password);
			
			
			// Step 4.2 ---> call executeQuery()
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}
	
	
public int updatePassword(String userName,String password) {
		
		Connection con = DBConnection.getConnection();
		int result = 0;
		
		
		try {
			// Step 3:
			final String SQLQUERY = "update login set password=? where username=?";
			PreparedStatement pstmt = con.prepareStatement(SQLQUERY);
			
			// step 4:
			
			// Step 4.1 ---> Inject the value of ? to prepared statement query
			pstmt.setString(2, userName);
			pstmt.setString(1,password);
			
			
			// Step 4.2 ---> call executeQuery()
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
		
	}
}
