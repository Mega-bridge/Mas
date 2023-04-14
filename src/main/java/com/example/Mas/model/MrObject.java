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
@Table(name="mr_object")
public class MrObject {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name="data_set_seq")
    private MrDataSet mrDataSet;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JoinColumn(name="object_code")
    private MrObjectCode mrObjectCode;
    @OneToOne
    @JoinColumn(name="name")
    private MrFamilyCode mrFamilyCode;
    private String position;
    private int angle;
    private String size;
    @CreationTimestamp
    private Timestamp createDate;
}
