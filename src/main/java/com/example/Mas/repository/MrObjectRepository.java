package com.example.Mas.repository;

import com.example.Mas.model.MrObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrObjectRepository extends JpaRepository<MrObject, Integer> {
}
