package com.example.Mas.repository;

import com.example.Mas.model.MrObjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrObjectImageRepository extends JpaRepository<MrObjectImage, Integer> {
}
