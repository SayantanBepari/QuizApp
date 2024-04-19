package com.quiz.question.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.question.model.Question;
import com.quiz.question.model.QuestionWrapper;
import com.quiz.question.model.Response;

public interface QuestionService {
	
	ResponseEntity<String> addQuestion(Question question);

	ResponseEntity<List<Question>> getAllQuestion();

	ResponseEntity<List<Question>> getQuestionsByCatagory(String catagory);

	ResponseEntity<List<Integer>> getQuestionsForQuiz(String catagory, Integer numQ);

	ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questionIds);

	ResponseEntity<Integer> getScore(List<Response> responses);

}
