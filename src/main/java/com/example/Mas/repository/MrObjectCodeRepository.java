package com.example.Mas.repository;

import com.example.Mas.model.MrObjectCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MrObjectCodeRepository extends JpaRepository<MrObjectCode, Integer> {
    List<MrObjectCode> findByType(Integer type);
    @Query(value = "SELECT * FROM mr_object_code moc WHERE id IN (:ids) ORDER BY FIELD(id, :ids)", nativeQuery = true)
    List<MrObjectCode> findAllByIds(@Param("ids") List<Integer> ids);
}
