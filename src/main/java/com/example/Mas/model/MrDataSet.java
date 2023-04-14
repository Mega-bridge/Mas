package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mr_data_set")
public class MrDataSet {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seq;
    @CreationTimestamp
    private Timestamp testDate;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JoinColumn(name="patient_info_id")
    private MrPatientInfo mrPatientInfo;
    @OneToOne
    @JoinColumn(name="object_id")
    private MrObject mrObject;
}
