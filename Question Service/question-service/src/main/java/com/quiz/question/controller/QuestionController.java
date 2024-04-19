package com.quiz.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.question.model.Question;
import com.quiz.question.model.QuestionWrapper;
import com.quiz.question.model.Response;
import com.quiz.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	Environment environmet;
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestion(){
		//questionService.getAllQuestion().forEach(System.out::println);
		//System.out.println("Printing !");
		return questionService.getAllQuestion();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);	
	}
	
	@GetMapping("/catagory/{catagory}")
	public ResponseEntity<List<Question>> getQuestionsByCatagory(@PathVariable String catagory){
		return questionService.getQuestionsByCatagory(catagory);
	}
	
	@GetMapping("/generateQuiz")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String catagory, @RequestParam Integer numQ){
		return questionService.getQuestionsForQuiz(catagory, numQ);
	}
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> questionIds){
		System.out.println(environmet.getProperty("local.server.port"));
		return questionService.getQuestionsFromIds(questionIds);	
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
	
	
	
	

}
