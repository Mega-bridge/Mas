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
    @NotNull(message = "회차 정보를 입력해주세요.")
    private Integer seq;
    @Column(name = "test_date", columnDefinition = "TIMESTAMP")
    private Timestamp testDate; // 회차 추가시 timestamp
    @NotNull(message = "사용자 email를 입력해주세요.")
    private String userEmail; // user.email
    private Integer patientInfoId; // mr_patient_info.id
    private Integer fishbowlCode; // mr_object_code.id
    private Integer waterHeight; // mr_object_code.water_height
    private Integer actionCount; // event 횟수
    private Integer fishCount; // 물고기 갯수
    private Integer etcCount; // 기타 갯수
    @Column(name = "total_time", columnDefinition = "TIMESTAMP")
    private Timestamp totalTime; // 총 소요시간
    @Column(name = "result_image", columnDefinition = "LONGTEXT")
    private String resultImage; // 결과 이미지
    private Integer detailFishId; // mr_detail_fish.id
    @Schema(description = "deleted", example = "false", defaultValue = "false")
    private boolean deleted; // 삭제 여부
}
