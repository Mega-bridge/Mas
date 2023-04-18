package com.example.Mas.repository;

import com.example.Mas.model.MrObjectCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrObjectCodeRepository extends JpaRepository<MrObjectCode, Integer> {
    List<MrObjectCode> findByType(Integer type);
}
