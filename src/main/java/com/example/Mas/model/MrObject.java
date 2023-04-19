package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mr_object")
public class MrObject {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer dataSetSeq; // mr_data_set.seq
    private Integer userId; // user.id
    private Integer objectCodeId; // mr_object_code.id
    private Integer name; // mr_family_code.id
    private Float x;
    private Float y;
    private Integer angle;
    private Integer width;
    private Integer height;
    private Integer objectSeq; // 저장된 순서
}
