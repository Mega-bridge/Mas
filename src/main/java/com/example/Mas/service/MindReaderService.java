package com.example.Mas.service;

import com.example.Mas.model.MrDataSet;
import com.example.Mas.model.MrObject;
import com.example.Mas.model.MrObjectImage;
import com.example.Mas.repository.MrDataSetRepository;
import com.example.Mas.repository.MrObjectImageRepository;
import com.example.Mas.repository.MrObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MindReaderService {
    @Autowired
    private MrDataSetRepository mrDataSetRepository;
    @Autowired
    private MrObjectRepository mrObjectRepository;
    @Autowired
    private MrObjectImageRepository mrObjectImageRepository;
    public MrDataSet createDataSet(MrDataSet mrDataSet) {
        return mrDataSetRepository.save(mrDataSet);
    }

    public MrObject createObject(MrObject mrObject) {
        return mrObjectRepository.save(mrObject);
    }

    public List<MrObjectImage> getObjectImage() {
        return mrObjectImageRepository.findAll();
    }
}
