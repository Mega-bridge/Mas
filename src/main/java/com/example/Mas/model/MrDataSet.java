package com.example.Mas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mr_data_set")
public class MrDataSet implements Serializable {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seq;
    private LocalDateTime testDate; // 회차 추가시 timestamp
    private Integer userId; // user.id
    private Integer patientInfoId; // mr_patient_info.id
    private Integer fishbowlCode; // mr_object_code.id
    private Integer waterHeight; // mr_object_code.water_height
    private Integer controlCount;
    private Integer fishCount;
    private Integer etcCount;
    private Integer resultSheetId; // mr_result_sheet.id
}
