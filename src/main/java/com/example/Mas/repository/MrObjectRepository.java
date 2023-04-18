package com.example.Mas.repository;

import com.example.Mas.model.MrObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrObjectRepository extends JpaRepository<MrObject, Integer> {
    List<MrObject> findByDataSetSeqAndUserId(Integer seq, Integer userId);
}
