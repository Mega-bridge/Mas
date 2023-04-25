package com.example.Mas.service;

import com.example.Mas.model.*;
import com.example.Mas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MrDataSet> findDataSetByUserEmail(String email) { return mrDataSetRepository.findByUserEmail(email); }
    public List<Object[]> findDistinctSeqAndTestDateByUserEmail(String email) { return mrDataSetRepository.findDistinctSeqAndTestDateByUserEmail(email); }
    public MrDataSet findDataSetBySeqAndUserEmail(Integer seq, String email) { return mrDataSetRepository.findBySeqAndUserEmail(seq, email); }
    public MrObject createObject(MrObject mrObject) { return mrObjectRepository.save(mrObject); }
    public List<MrObject> createObjectBySeq(List<MrObject> mrObjects) { return mrObjectRepository.saveAll(mrObjects); }
    public List<MrObject> findObjectByDataSetSeqAndUserEmail(Integer seq, String email) { return mrObjectRepository.findByDataSetSeqAndUserEmailOrderByObjectSeq(seq, email); }
    public List<MrObjectCode> findObjectCodeByDataSetSeqAndUserEmail(Integer seq, String email) {
        List<MrObject> mrObjects = mrObjectRepository.findByDataSetSeqAndUserEmailOrderByObjectSeq(seq, email);
        List<Integer> ids = new ArrayList<>();

        if(mrObjects != null) {
            for(MrObject mrObject : mrObjects) {
                ids.add(mrObject.getObjectCodeId());
            }
        }

        return mrObjectCodeRepository.findAllByIds(ids);
    }
    public List<MrObjectImage> findAllObjectImage() { return mrObjectImageRepository.findAll(); }
    public List<MrFamilyCode> findAllFamily() { return mrFamilyCodeRepository.findAll(); }
    public Optional<MrObjectCode> findObjectCodeById(Integer id) { return mrObjectCodeRepository.findById(id); }
    public List<MrObjectCode> findObjectCodeByType(Integer type) { return mrObjectCodeRepository.findByType(type); }
    public List<MrFamilyRelationCode> findAllFamilyRelation() { return mrFamilyRelationCodeRepository.findAll(); }
    public List<MrGenderCode> findAllGender() { return mrGenderCodeRepository.findAll(); }
    public List<MrJobCode> findAllJob() { return mrJobCodeRepository.findAll(); }
}
