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
@Table(name="mr_result_sheet")
public class MrResultSheet implements Serializable {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "dataSet id를 입력해주세요.")
    private Integer dataSetId;
    @NotNull(message = "내담자 email 정보를 입력해주세요.")
    private String userEmail; // user.email, 내담자 email
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String questionIds;
    private String answerIds;
    @NotNull(message = "상담사 email 정보를 입력해주세요.")
    private String counselor; // user.email, 상담사 email
    @Column(name = "create_date", columnDefinition = "TIMESTAMP")
    private Timestamp createDate; // 상담 결과지 작성시 timestamp
}
