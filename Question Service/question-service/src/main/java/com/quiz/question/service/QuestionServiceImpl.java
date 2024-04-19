package com.quiz.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.question.dao.QuestionDao;
import com.quiz.question.model.Question;
import com.quiz.question.model.QuestionWrapper;
import com.quiz.question.model.Response;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;

	@Override
	public ResponseEntity<List<Question>> getAllQuestion() {
		try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Question saved successfully !", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Unable to save question !", HttpStatus.INTERNAL_SERVER_ERROR);
		
		//return questionDao.findById(question.getId()).get();
	}

	@Override
	public ResponseEntity<List<Question>> getQuestionsByCatagory(String catagory) {
		try {
			return new ResponseEntity<>(questionDao.getQuestionsByCatagory(catagory), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String catagory, Integer numQ) {
		//System.out.println("Printing the values from quiz service.. \n catagory : "+catagory+"\n numQ : "+numQ);
		List<Integer> questions = questionDao.getRandomQuestionsByCatagory(catagory, numQ);
		return new ResponseEntity<>(questions, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> questionIds) {
		
		List<QuestionWrapper> Wrappers = new ArrayList<>();
		List<Question> Questions = new ArrayList<>();
		
		for(Integer id : questionIds) {
			Questions.add(questionDao.findById(id).get());
		}
		
		for(Question question : Questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			Wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(Wrappers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> getScore(List<Response> responses) {
		Integer score = 0;
		
		for(Response response : responses) {
			Question question = questionDao.findById(response.getQuestionId()).get();
			if(question.getRightAnswere().equals(response.getAnswere())) {
				score+=1;
			}
		}
		return new ResponseEntity<>(score, HttpStatus.OK);
	}

}
