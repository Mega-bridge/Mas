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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mindReader")
public class MindReaderController {
    @Autowired
    private MindReaderService mindReaderService;

    @ApiOperation(value = "DataSet 생성", notes = "DataSet을 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/")
    public ResponseEntity<MrDataSet> createDataSet(@RequestBody MrDataSet mrDataSet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createDataSet(mrDataSet));
    }
    @ApiOperation(value = "오브젝트 생성", notes = "오브젝트를 생성한다.", httpMethod = "POST")
    @PostMapping(value = "/object")
    public ResponseEntity<MrObject> createObject(@RequestBody MrObject mrObject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mindReaderService.createObject(mrObject));
    }

    @ApiOperation(value = "오브젝트 이미지 정보 조회", notes = "이미지 path 정보 등을 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/objectImage")
    public ResponseEntity<List<MrObjectImage>> getObjectImage () {
        return ResponseEntity.ok(mindReaderService.getObjectImage());
    }

    @ApiOperation(value = "가족 정보 조회", notes = "가족 정보를 조회한다.", httpMethod = "GET")
    @GetMapping(value = "/family")
    public ResponseEntity<List<MrFamilyCode>> getFamilyCode () {
        return ResponseEntity.ok(mindReaderService.getFamilyCode());
    }
}
