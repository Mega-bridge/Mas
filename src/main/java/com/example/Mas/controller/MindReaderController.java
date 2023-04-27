package com.example.Mas.controller;

import com.example.Mas.model.*;
import com.example.Mas.service.MindReaderService;
import com.example.Mas.utils.SecurityUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mindReader")
public class MindReaderController {
    @Autowired
    private MindReaderService mindReaderService;

    /**
     * mrDataSet
     */
    @ApiOperation(value = "데이터 세트 생성", notes = "데이터 세트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/dataSet")
    public ResponseEntity<MrDataSet> createDataSet(@RequestBody MrDataSet mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSet(mrDataSet));
    }

    @Deprecated
    @ApiOperation(value = "오브젝트별 데이터 세트 생성", notes = "오브젝트별 데이터 세트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/object/dataSet")
    public ResponseEntity<List<MrDataSet>> createDataSetByObject(@RequestBody List<MrDataSet> mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSetByObject(mrDataSet));
    }

    @ApiOperation(value = "사용자 데이터 세트 조회", notes = "사용자 데이터 세트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/dataSet")
    public ResponseEntity<List<MrDataSet>> findDataSetByUserEmail(
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        return ResponseEntity.ok(mindReaderService.findDataSetByUserEmail(email));
    }

    @Deprecated
    @ApiOperation(value = "사용자 회차목록 조회", notes = "사용자 회차목록을 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/dataSet/seq")
    public ResponseEntity<?> findDistinctSeqAndTestDateByUserEmail(
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        return ResponseEntity.ok(mindReaderService.findDistinctSeqAndTestDateByUserEmail(email));
    }

    @ApiOperation(value = "회차별 사용자 데이터 세트 조회", notes = "회차별 사용자 데이터 세트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/dataSet/{seq}")
    public ResponseEntity<MrDataSet> findDataSetBySeqAndUserEmail(
            @PathVariable("seq") Integer seq,
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        MrDataSet mrDataSet = mindReaderService.findDataSetBySeqAndUserEmail(seq, email);

        if(mrDataSet == null) {
            log.warn("데이터 세트 정보를 찾을 수 없습니다.[mrDataSet: null]");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mrDataSet);
    }

    @ApiOperation(value = "데이터 세트 삭제", notes = "데이터 세트를 삭제한다.", httpMethod = "PATCH")
    @PatchMapping("/dataSet/{id}")
    public ResponseEntity<List<MrDataSet>> updateDataSetByIdAndUserEmail(@PathVariable("id") Integer id) {
        String email = SecurityUtils.getUserName();
        return ResponseEntity.ok(mindReaderService.updateDataSetByIdAndUserEmail(id, email));
    }

    /**
     * mrObject
     */
    @Deprecated
    @ApiOperation(value = "오브젝트 생성", notes = "오브젝트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/object")
    public ResponseEntity<MrObject> createObject(@RequestBody MrObject mrObject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createObject(mrObject));
    }

    @ApiOperation(value = "회차별 오브젝트 생성", notes = "회차별 오브젝트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/seq/object")
    public ResponseEntity<List<MrObject>> createObjectBySeq(@RequestBody List<MrObject> mrObjects) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createObjectBySeq(mrObjects));
    }

    @ApiOperation(value = "회차별 사용자 오브젝트 조회", notes = "회차별 사용자 오브젝트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/object/{seq}")
    public ResponseEntity<List<MrObject>> findObjectByDataSetSeqAndUserEmail(
            @PathVariable("seq") Integer seq,
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        return ResponseEntity.ok(mindReaderService.findObjectByDataSetSeqAndUserEmail(seq, email));
    }

    /**
     * Object Image, Object Name(family)
     */
    @ApiOperation(value = "오브젝트 이미지 리스트 조회", notes = "이미지 path 정보 등을 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectImage")
    public ResponseEntity<List<MrObjectImage>> findAllObjectImage () {
        return ResponseEntity.ok(mindReaderService.findAllObjectImage());
    }

    @ApiOperation(value = "가족 리스트 조회", notes = "가족 리스트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/family")
    public ResponseEntity<List<MrFamilyCode>> findAllFamily () {
        return ResponseEntity.ok(mindReaderService.findAllFamily());
    }

    /**
     * ObjectCode
     */
    @ApiOperation(value = "오브젝트 코드 조회", notes = "오브젝트 코드 아이디로 오브젝트 코드를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectCode/{id}")
    public ResponseEntity<?> findObjectCodeById (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(mindReaderService.findObjectCodeById(id));
    }

    @ApiOperation(value = "타입별 오브젝트 코드 조회", notes = "오브젝트 코드 타입으로 오브젝트 코드를 조회한다. type: 0=물고기, 1=어항, 2=기타", httpMethod = "GET")
    @GetMapping(value = "/{type}/objectCode")
    public ResponseEntity<List<MrObjectCode>> findObjectCodeByType (@PathVariable("type") Integer type) {
        return ResponseEntity.ok(mindReaderService.findObjectCodeByType(type));
    }

    @ApiOperation(value = "회차별 사용자 오브젝트 순서 목록 조회", notes = "회차별 사용자 오브젝트 순서 목록을 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/user/objectCode/{seq}")
    public ResponseEntity<List<MrObjectCode>> findObjectCodeByDataSetSeqAndUserEmail(
            @PathVariable("seq") Integer seq,
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        return ResponseEntity.ok(mindReaderService.findObjectCodeByDataSetSeqAndUserEmail(seq, email));
    }

    /**
     * 내담자 추가 입력 정보
     */
    @ApiOperation(value = "내담자 추가 입력 정보 생성", notes = "내담자 추가 입력 정보를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/patientInfo")
    public ResponseEntity<MrPatientInfo> createPatientInfo(@RequestBody MrPatientInfo mrPatientInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createPatientInfo(mrPatientInfo));
    }

    @ApiOperation(value = "내담자 추가 입력 정보 조회", notes = "내담자 추가 입력 정보를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/patientInfo")
    public ResponseEntity<MrPatientInfo> findPatientInfoByUserEmail(
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        String email = userEmail;
        if(email == null) email = SecurityUtils.getUserName();
        MrPatientInfo mrPatientInfo = mindReaderService.findPatientInfoByUserEmail(email);

        if(mrPatientInfo == null) {
            log.warn("내담자 추가 입력 정보를 찾을 수 없습니다.[mrPatientInfo: null]");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mrPatientInfo);
    }

    @ApiOperation(value = "가족 관계 리스트 조회", notes = "가족 관계 리스트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/familyRelation")
    public ResponseEntity<List<MrFamilyRelationCode>> findAllFamilyRelation () {
        return ResponseEntity.ok(mindReaderService.findAllFamilyRelation());
    }

    @ApiOperation(value = "성별 리스트 조회", notes = "성별 리스트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/gender")
    public ResponseEntity<List<MrGenderCode>> findAllGender () {
        return ResponseEntity.ok(mindReaderService.findAllGender());
    }

    @ApiOperation(value = "직업 리스트 조회", notes = "직업 리스트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/job")
    public ResponseEntity<List<MrJobCode>> findAllJob () {
        return ResponseEntity.ok(mindReaderService.findAllJob());
    }
}
