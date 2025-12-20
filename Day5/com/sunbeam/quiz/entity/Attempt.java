package com.sunbeam.quiz.entity;

import java.time.*;
import java.util.*;

public class Attempt {
	Scanner sc= new Scanner(System.in);
	public int attemptId;
	public  int quizId;
	public int studentId;
	public int  finalscore;
	public int totalquestion;
	public  LocalDateTime attemptTime;
	
	
	public Attempt(int attemptId, int quizId, int studentId, int finalscore, int totalquestion, LocalDateTime attemptTime) {
		super();
		this.attemptId = attemptId;
		this.quizId = quizId;
		this.studentId = studentId;
		this.finalscore = finalscore;
		this.totalquestion = totalquestion;
		this.attemptTime = attemptTime;
	}
	public int getattemptId() {
		return attemptId;
	}
	public void setattemptId(int attemptId) {
		this.attemptId = attemptId;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getFinalscore() {
		return finalscore;
	}
	public void setFinalscore(int finalscore) {
		this.finalscore = finalscore;
	}
	public int getTotalquestion() {
		return totalquestion;
	}
	public void setTotalquestion(int totalquestion) {
		this.totalquestion = totalquestion;
	}
	public LocalDateTime getAttemptTime() {
		return attemptTime;
	}
	public void setAttemptTime(LocalDateTime attemptTime) {
		this.attemptTime = attemptTime;
	}
	public void acceptA(Scanner sc) {
		System.out.println("attempt id");
		attemptId=sc.nextInt();
		 System.out.println("quiz Id");
		 quizId=sc.nextInt();
		 System.out.println("student id");
		 studentId=sc.nextInt();
		 System.out.println(" final score");
		 finalscore=sc.nextInt();
		 System.out.println("total question");
		 totalquestion=sc.nextInt();
		
	}
	@Override
	public
	String toString() {
		return "[id=" + attemptId + ", Quizid=" + quizId + ", studentId=" +studentId  + ", finalscore=" + finalscore + ",totalquestion="+totalquestion+"]";
	}	
	
 
}

