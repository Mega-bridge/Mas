package com.example.Mas.repository;

import com.example.Mas.model.MrDataSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrDataSetRepository extends JpaRepository<MrDataSet, Integer> {
    List<MrDataSet> findByUserId(Integer userId);
    @Query(value = "SELECT DISTINCT m.seq, m.test_date FROM mr_data_set m WHERE m.user_id = :userId", nativeQuery = true)
    List<Object[]> findDistinctSeqAndTestDateByUserId(@Param("userId") Integer userId);
    MrDataSet findBySeqAndUserId(Integer seq, Integer userId);
}
