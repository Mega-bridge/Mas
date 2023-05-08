package com.example.Mas.repository;

import com.example.Mas.model.MrResultSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrResultSheetRepository extends JpaRepository<MrResultSheet, Integer> {
    MrResultSheet findByDataSetId(Integer dataSetId);
}
