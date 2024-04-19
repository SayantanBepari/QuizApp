package com.quiz.quiz.model;

import lombok.Data;

@Data
public class QuizDto {

	private String catagoryName;
	private Integer numQuestions;
	private String title;
	
	public QuizDto() {}
	
	

//	public QuizDto(String catagoryName, Integer numQuestion, String title) {
//		super();
//		this.catagoryName = catagoryName;
//		this.numQuestions = numQuestion;
//		this.title = title;
//	}



	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public Integer getNumQuestions() {
		return numQuestions;
	}

	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
}
