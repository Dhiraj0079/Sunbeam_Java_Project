package com.sunbeam.quiz.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sunbeam.quiz.util.DButil;
import com.sunbeam.quiz.entity.Question;

public class QuestionDao implements AutoCloseable {
	Connection connection=null;
	 public QuestionDao() throws SQLException {
		 connection=DButil.getConnection();
	 }
	 
	 public void insert( Question q) throws SQLException {
		 String sql="INSERT INTO questions (id,question_text,option_a,option_b,option_c,option_d,correct_option) VALUES (?,?,?,?,?,?,?)";
		 try(PreparedStatement ps=connection.prepareStatement(sql)){
			 ps.setInt(1,q.questionId);
			 ps.setString(2, q.text);
			 ps.setString(3, q.a);
			 ps.setString(4, q.b);
			 ps.setString(5, q.c);
			 ps.setString(6, q.d);
			 ps.setString(7, String.valueOf(q.correct));
			 ps.executeUpdate();
		 }
	 }

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		if(connection!=null) {
			connection.close();
			connection=null;
		}
		
	}

}

