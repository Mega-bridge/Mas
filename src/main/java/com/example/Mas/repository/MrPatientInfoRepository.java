package com.example.Mas.repository;

import com.example.Mas.model.MrPatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MrPatientInfoRepository extends JpaRepository<MrPatientInfo, Integer> {
    MrPatientInfo findByUserEmail(String email);
}
