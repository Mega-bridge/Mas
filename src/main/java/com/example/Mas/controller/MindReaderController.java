package com.example.Mas.controller;

import com.example.Mas.model.MrDataSet;
import com.example.Mas.model.MrFamilyCode;
import com.example.Mas.model.MrObject;
import com.example.Mas.model.MrObjectImage;
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

    @ApiOperation(value = "DataSet 생성", notes = "DataSet을 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/dataSet")
    public ResponseEntity<MrDataSet> createDataSet(@RequestBody MrDataSet mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSet(mrDataSet));
    }
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

    @ApiOperation(value = "오브젝트 이미지 정보 조회", notes = "이미지 path 정보 등을 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectImage")
    public ResponseEntity<List<MrObjectImage>> findObjectImage () {
        return ResponseEntity.ok(mindReaderService.findObjectImage());
    }

    @ApiOperation(value = "가족 정보 조회", notes = "가족 정보를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/family")
    public ResponseEntity<List<MrFamilyCode>> findFamilyCode () {
        return ResponseEntity.ok(mindReaderService.findFamilyCode());
    }
}
