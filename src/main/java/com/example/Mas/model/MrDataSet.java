package com.example.Mas.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name="mr_data_set")
public class MrDataSet implements Serializable {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer seq;
    private Timestamp testDate; // 회차 추가시 timestamp
    @NotNull
    private String userEmail; // user.email
    private Integer patientInfoId; // mr_patient_info.id
    private Integer fishbowlCode; // mr_object_code.id
    private Integer waterHeight; // mr_object_code.water_height
    private Integer actionCount; // event 횟수
    private Integer fishCount; // 물고기 갯수
    private Integer etcCount; // 기타 갯수
    private Timestamp totalTime; // 총 소요시간
    @Column(name = "result_image", columnDefinition = "LONGTEXT")
    private String resultImage; // 결과 이미지
    private Integer resultSheetId; // mr_result_sheet.id
    @Schema(description = "deleted", example = "false", defaultValue = "false")
    private boolean deleted; // 삭제 여부
}
