package com.sunbeam.quiz.entity;

public class Quiz {
	public int quizId;
	public String title;
	public int creator_id;
	public Quiz()
	{
		
	}
	public Quiz(int quizId, String title, int creator_id) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.creator_id = creator_id;
	}
	public int getquizId() {
		return quizId;
	}
	public void setquizId(int quizId) {
		this.quizId = quizId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + quizId + ", title=" + title + ", creator_id=" + creator_id + "]";
	}
	
}

