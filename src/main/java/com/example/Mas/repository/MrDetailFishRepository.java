package com.example.Mas.repository;

import com.example.Mas.model.MrDetailFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrDetailFishRepository extends JpaRepository<MrDetailFish, Integer> {
}
