package com.example.Mas.service;

import com.example.Mas.model.MrDataSet;
import com.example.Mas.model.MrFamilyCode;
import com.example.Mas.model.MrObject;
import com.example.Mas.model.MrObjectImage;
import com.example.Mas.repository.MrDataSetRepository;
import com.example.Mas.repository.MrFamilyCodeRepository;
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
    @Autowired
    private MrFamilyCodeRepository mrFamilyCodeRepository;
    public MrDataSet createDataSet(MrDataSet mrDataSet) {
        return mrDataSetRepository.save(mrDataSet);
    }
    public MrObject createObject(MrObject mrObject) { return mrObjectRepository.save(mrObject); }
    public List<MrObject> createObjects(List<MrObject> mrObjects) { return mrObjectRepository.saveAll(mrObjects); }
    public List<MrObject> findByDataSetSeqAndUserId(Integer seq, Integer userId) { return mrObjectRepository.findByDataSetSeqAndUserId(seq, userId); }
    public List<MrObjectImage> findObjectImage() {
        return mrObjectImageRepository.findAll();
    }
    public List<MrFamilyCode> findFamilyCode() { return mrFamilyCodeRepository.findAll(); }
}
