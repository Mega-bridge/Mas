package com.example.Mas.repository;

import com.example.Mas.model.MrJobCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrJobCodeRepository extends JpaRepository<MrJobCode, Integer> {
}
