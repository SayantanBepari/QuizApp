package com.quiz.quiz.model;

import lombok.Data;

@Data
public class Response {

	private Integer questionId;
	private String answere;
	
	public Response() {
		super();
	}
	
	public Response(Integer questionId, String answere) {
		super();
		this.questionId = questionId;
		this.answere = answere;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getAnswere() {
		return answere;
	}

	public void setAnswere(String answere) {
		this.answere = answere;
	}

	@Override
	public String toString() {
		return "Response [questionId=" + questionId + ", answere=" + answere + "]";
	}
	
	
	
}
