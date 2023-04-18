package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mr_data_set")
public class MrDataSet {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seq;
    @CreationTimestamp
    private LocalDateTime testDate;
    private Integer userId; // user.id
    private Integer patientInfoId; // mr_patient_info.id
    private Integer controlCount;
    private Integer fishCount;
    private Integer objectId; // mr_object.id
}
