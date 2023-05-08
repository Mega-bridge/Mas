package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mr_object")
public class MrObject implements Serializable {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "회차 정보를 입력해주세요.")
    private Integer dataSetSeq; // mr_data_set.seq
    @NotNull(message = "사용자 email 정보를 입력해주세요.")
    private String userEmail; // user.email
    @NotNull(message = "객체 코드 id를 입력해주세요.")
    private Integer objectCodeId; // mr_object_code.id
    private Integer name; // mr_family_code.id
    private Float x;
    private Float y;
    private Integer angle;
    private Integer width;
    private Integer height;
    private Integer objectSeq; // 저장된 순서
    @Column(name = "create_date", columnDefinition = "TIMESTAMP(3)")
    private Timestamp createDate; // 오브젝트 생성시 timestamp
}
