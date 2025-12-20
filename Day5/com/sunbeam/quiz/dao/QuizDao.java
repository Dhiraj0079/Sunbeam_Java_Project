package com.sunbeam.quiz.dao;
import com.sunbeam.quiz.entity.Quiz;
import com.sunbeam.quiz.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizDao implements AutoCloseable{
	Connection connection=null;
	public QuizDao() throws SQLException{
		connection=DButil.getConnection();
	}
	public int insert(Quiz q) throws SQLException{
		String sql="insert into quizzes(title,creator_id)values(?,?)";
		try(PreparedStatement insertStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			insertStatement.setInt(2, q.creator_id);
			insertStatement.setString(1, q.title);
			insertStatement.executeUpdate();
			ResultSet rs=insertStatement.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}
	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
}
