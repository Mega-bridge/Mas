package com.example.Mas.repository;

import com.example.Mas.model.MrGenderCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrGenderCodeRepository extends JpaRepository<MrGenderCode, Integer> {
}
