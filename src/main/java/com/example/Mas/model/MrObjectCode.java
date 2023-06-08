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
@Table(name="mr_object_code")
public class MrObjectCode {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type; // 0=물고기, 1=어항, 2=기타
    private Integer face; // 0=기본, 1=삐진, 2=슬픈, 3=웃는, 4=화난
    private Integer waterHeight; // 0=물없는, 1=물적은, 2=물충분, 3=물많은
    private Integer etcDepth; // 0=물풀, 1=물방울, 2=돌, 3=먹이, 4=어항꾸미기, 5=물고기외
    private String code;
    private String description;
}
