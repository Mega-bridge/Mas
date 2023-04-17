package com.example.Mas.repository;

import com.example.Mas.model.MrFamilyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrFamilyCodeRepository extends JpaRepository<MrFamilyCode, Integer> {
}
