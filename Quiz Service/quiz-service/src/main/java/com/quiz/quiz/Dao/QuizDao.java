package com.quiz.quiz.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quiz.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
