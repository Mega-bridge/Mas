package com.example.Mas.repository;

import com.example.Mas.model.MrDataSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrDataSetRepository extends JpaRepository<MrDataSet, Integer> {
}
