package com.example.Mas.repository;

import com.example.Mas.model.MrDataSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrDataSetRepository extends JpaRepository<MrDataSet, Integer> {
    List<MrDataSet> findByUserId(Integer userId);
//    @Query(value = "SELECT DISTINCT mds.seq FROM mr_data_set mds WHERE mds.user_id = :userId", nativeQuery = true)
    List<MrDataSet> findDistinctSeqByUserId(Integer userId);
    List<MrDataSet> findBySeqAndUserId(Integer seq, Integer userId);
}
