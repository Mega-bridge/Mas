package com.example.Mas.repository;

import com.example.Mas.model.MrAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrAnswerRepository extends JpaRepository<MrAnswer, Integer> {
    List<MrAnswer> findAnswerByQuestionId(Integer questionId);
}
