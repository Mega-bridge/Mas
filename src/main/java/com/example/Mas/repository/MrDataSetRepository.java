package com.example.Mas.repository;

import com.example.Mas.model.MrDataSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MrDataSetRepository extends JpaRepository<MrDataSet, Integer> {
    List<MrDataSet> findByUserEmailAndDeleted(String email, boolean deleted);
    @Query(value = "SELECT DISTINCT m.seq, m.test_date FROM mr_data_set m WHERE m.user_email = :email", nativeQuery = true)
    List<Object[]> findDistinctSeqAndTestDateByUserEmail(@Param("email") String email);
    MrDataSet findBySeqAndUserEmail(Integer seq, String email);
    @Modifying
    @Transactional
    @Query(value = "UPDATE mr_data_set m SET m.deleted = TRUE WHERE m.id = :id AND m.user_email = :email", nativeQuery = true)
    void updateDeletedByIdAndUserEmail(@Param("id") Integer id, @Param("email") String email);
}
