package com.example.Mas.controller;

import com.example.Mas.model.*;
import com.example.Mas.service.MindReaderService;
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

//    DataSet
    @Deprecated
    @ApiOperation(value = "DataSet 생성", notes = "DataSet을 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/dataSet")
    public ResponseEntity<MrDataSet> createDataSet(@RequestBody MrDataSet mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSet(mrDataSet));
    }

    @ApiOperation(value = "오브젝트별 데이터 세트 생성", notes = "오브젝트별 데이터 세트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/dataSetObject")
    public ResponseEntity<List<MrDataSet>> createDataSetObject(@RequestBody List<MrDataSet> mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSetObject(mrDataSet));
    }

//    Object
    @Deprecated
    @ApiOperation(value = "오브젝트 생성", notes = "오브젝트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/object")
    public ResponseEntity<MrObject> createObject(@RequestBody MrObject mrObject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createObject(mrObject));
    }

    @ApiOperation(value = "회차별 오브젝트 생성", notes = "회차별 오브젝트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/objects")
    public ResponseEntity<List<MrObject>> createObjects(@RequestBody List<MrObject> mrObjects) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createObjects(mrObjects));
    }

    @ApiOperation(value = "회차별 사용자 오브젝트 조회", notes = "회차별 사용자 오브젝트를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objects/{seq}/{userId}")
    public ResponseEntity<List<MrObject>> findByDataSetSeqAndUserId(@PathVariable("seq") Integer seq, @PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(mindReaderService.findByDataSetSeqAndUserId(seq, userId));
    }

//    Object Image, Object Name 조회
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

    @ApiOperation(value = "오브젝트 코드 조회", notes = "오브젝트 코드 아이디로 오브젝트 코드를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectCode/{id}")
    public ResponseEntity<?> findObjectCodeById (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(mindReaderService.findObjectCodeById(id));
    }

    @ApiOperation(value = "타입별 오브젝트 코드 조회", notes = "오브젝트 코드 타입으로 오브젝트 코드를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectCodeList/{type}")
    public ResponseEntity<List<MrObjectCode>> findObjectCodeByType (@PathVariable("type") Integer type) {
        return ResponseEntity.ok(mindReaderService.findObjectCodeByType(type));
    }

//    내담자 추가 입력 정보
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
