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
    private int id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JoinColumn(name="gender_id")
    private MrGenderCode mrGenderCode;
    @OneToOne
    @JoinColumn(name="job_id")
    private MrJobCode mrJobCode;
    private String email;
    private int age;
    private int familyNum;
    private String familyInfo;
    private String familyRelationCode;
}
