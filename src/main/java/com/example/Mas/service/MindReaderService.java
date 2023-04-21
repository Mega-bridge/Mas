package com.example.Mas.service;

import com.example.Mas.model.*;
import com.example.Mas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private MrObjectCodeRepository mrObjectCodeRepository;
    @Autowired
    private MrFamilyRelationCodeRepository mrFamilyRelationCodeRepository;
    @Autowired
    private MrGenderCodeRepository mrGenderCodeRepository;
    @Autowired
    private MrJobCodeRepository mrJobCodeRepository;

    public MrDataSet createDataSet(MrDataSet mrDataSet) { return mrDataSetRepository.save(mrDataSet); }
    public List<MrDataSet> createDataSetByObject(List<MrDataSet> mrDataSet) { return mrDataSetRepository.saveAll(mrDataSet); }
    public List<MrDataSet> findDataSetByUserId(Integer userId) { return mrDataSetRepository.findByUserId(userId); }
    public List<Object[]> findDistinctSeqAndTestDateByUserId(Integer userId) { return mrDataSetRepository.findDistinctSeqAndTestDateByUserId(userId); }
    public MrDataSet findDataSetBySeqAndUserId(Integer seq, Integer userId) { return mrDataSetRepository.findBySeqAndUserId(seq, userId); }
    public MrObject createObject(MrObject mrObject) { return mrObjectRepository.save(mrObject); }
    public List<MrObject> createObjectBySeq(List<MrObject> mrObjects) { return mrObjectRepository.saveAll(mrObjects); }
    public List<MrObject> findObjectByDataSetSeqAndUserId(Integer seq, Integer userId) { return mrObjectRepository.findByDataSetSeqAndUserId(seq, userId); }
    public List<MrObjectImage> findAllObjectImage() { return mrObjectImageRepository.findAll(); }
    public List<MrFamilyCode> findAllFamily() { return mrFamilyCodeRepository.findAll(); }
    public Optional<MrObjectCode> findObjectCodeById(Integer id) { return mrObjectCodeRepository.findById(id); }
    public List<MrObjectCode> findObjectCodeByType(Integer type) { return mrObjectCodeRepository.findByType(type); }
    public List<MrFamilyRelationCode> findAllFamilyRelation() { return mrFamilyRelationCodeRepository.findAll(); }
    public List<MrGenderCode> findAllGender() { return mrGenderCodeRepository.findAll(); }
    public List<MrJobCode> findAllJob() { return mrJobCodeRepository.findAll(); }
}
