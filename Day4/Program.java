package com.Sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {
	private static final String URL = "jdbc:mysql://localhost:3306/WORLD";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public static void getAllStudents() {
		String sql="SELECT * FROM students";
		try{
			Connection connection=getConnection();
			PreparedStatement selectStatement=connection.prepareStatement(sql);
			ResultSet rs=selectStatement.executeQuery(sql);
			while(rs.next()) {
				int roll=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String course=rs.getString(4);
				System.out.println(roll+"-"+name+"-"+email+"-"+course);
				
			}
			connection.close();
			selectStatement.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
	}
		public static void insertStudent(){
			int roll=126;
			String name="Raj";
			String email="raj@gmail.com";
			String course="ETC";
			String sql="INSERT INTO students(roll,name,email,course)VALUES(?,?,?,?)";
			try {
				Connection connection=getConnection();
				PreparedStatement insertStatement=connection.prepareStatement(sql);
				insertStatement.setInt(1,roll);
				insertStatement.setString(2,name);
				insertStatement.setString(3,email);
				insertStatement.setString(4,course);
				insertStatement.executeUpdate();
				connection.close();
				System.out.println("Student inserted");
				
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	
		// update
		public static void updateStudent() {
	        int roll=125;
		    String name = "Marcos";
		    String email = "marcos@gmail.com";
		    String course="Hell";

		    String sql = "UPDATE students SET name = ?, email = ?, course = ? WHERE roll = ?";

		    try {
		        Connection connection = getConnection();

		        PreparedStatement updateStatement = connection.prepareStatement(sql);

		        updateStatement.setInt(1, roll);
		        updateStatement.setString(2, name);
		        updateStatement.setString(3, email);
		        updateStatement.setString(4, course);
		        updateStatement.executeUpdate();
		    //    int rows = updateStatement.executeUpdate();

		      //  System.out.println(rows + " student updated");
		        System.out.println("Updated");
		        updateStatement.close();
		        connection.close();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		// delete
		public static void deleteStudent() {
			int roll=123;
		    String sql="Delete from students where roll=?";
		    try {
		        Connection connection=getConnection();
		        PreparedStatement deleteStatement=connection.prepareStatement(sql);
		        deleteStatement.setInt(1, roll);
		        deleteStatement.executeUpdate();
		        connection.close();
		        deleteStatement.close();
		        System.out.println("Student deleted");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		

		public  static void main(String[] args) {
			getAllStudents();
			insertStudent();
			updateStudent();
			deleteStudent();		
			
		}
		
	
	
	
} 


