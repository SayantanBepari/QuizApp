package com.quiz.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.quiz.Dao.QuizDao;
import com.quiz.quiz.feign.QuizInterface;
import com.quiz.quiz.model.QuestionWrapper;
import com.quiz.quiz.model.Quiz;
import com.quiz.quiz.model.Response;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	
	
	@Override
	public ResponseEntity<String> createQuiz(String catagory, Integer numQ, String title) {

		List<Integer> questions = quizInterface.getQuestionsForQuiz(catagory, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);

		quizDao.save(quiz);

		return new ResponseEntity<>("Quiz Created !", HttpStatus.CREATED);
	}



	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromIds(questionIds);
		return questions;
	}
	
	@Override
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
		
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}


	
}