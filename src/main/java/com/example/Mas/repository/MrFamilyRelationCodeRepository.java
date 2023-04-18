package com.example.Mas.repository;

import com.example.Mas.model.MrFamilyRelationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrFamilyRelationCodeRepository extends JpaRepository<MrFamilyRelationCode, Integer> {
}
