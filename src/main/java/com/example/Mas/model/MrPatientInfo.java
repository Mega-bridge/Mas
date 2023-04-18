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
@Table(name="mr_patient_info")
public class MrPatientInfo {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId; // user.id
    private Integer genderId; // mr_gender_code.id
    private Integer jobId; // mr_job_code.id
    private String email;
    private Integer age;
    private Integer familyNum;
    private String familyInfo;
    private String familyRelationCode;
}
