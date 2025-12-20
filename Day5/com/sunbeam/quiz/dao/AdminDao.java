package com.sunbeam.quiz.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.quiz.entity.User;
import com.sunbeam.quiz.util.DButil;

public class AdminDao implements AutoCloseable{
	Connection con;
	User currentuser = null;
	public AdminDao() throws SQLException {
		con=DButil.getConnection();
	}

	public boolean adminLogin(String email,String password_hash) throws SQLException {
		String sql = "select * from users where email=? and password_hash=?";
		try(PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password_hash);
			ResultSet rs = stmt.executeQuery();
			
			
			
			if(rs.next()) {
			
				return true;
			}
			rs.close();
			con.close();
			
		}
		
		return false;
	}
	
	@Override
	public void close() throws SQLException {
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
