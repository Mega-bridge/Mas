package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@DynamicUpdate
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
    @NotNull(message = "사용자 email를 입력해주세요.")
    private String userEmail; // user.email
    private String userName; // user.user_name
    private Integer genderId; // mr_gender_code.id
    private Integer jobId; // mr_job_code.id
    private Integer age;
    private Integer familyNum; // 가족수
    private String familyInfo; // 가족 구성원
    private String familyRelation; // 가족간의 관계
}
