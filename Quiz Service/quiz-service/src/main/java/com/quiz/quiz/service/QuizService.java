package com.quiz.quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.quiz.model.QuestionWrapper;
import com.quiz.quiz.model.Response;

public interface QuizService {

	public ResponseEntity<String> createQuiz(String catagory, Integer numQ, String title);

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);

}
