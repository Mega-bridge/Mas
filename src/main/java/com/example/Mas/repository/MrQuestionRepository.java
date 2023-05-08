package com.example.Mas.repository;

import com.example.Mas.model.MrQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrQuestionRepository extends JpaRepository<MrQuestion, Integer> {
}
