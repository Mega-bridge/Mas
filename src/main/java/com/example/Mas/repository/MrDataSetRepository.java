package com.example.Mas.repository;

import com.example.Mas.model.MrDataSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrDataSetRepository extends JpaRepository<MrDataSet, Integer> {
    List<MrDataSet> findByUserEmail(String email);
    @Query(value = "SELECT DISTINCT m.seq, m.test_date FROM mr_data_set m WHERE m.user_email = :email", nativeQuery = true)
    List<Object[]> findDistinctSeqAndTestDateByUserEmail(@Param("email") String email);
    MrDataSet findBySeqAndUserEmail(Integer seq, String email);
}
