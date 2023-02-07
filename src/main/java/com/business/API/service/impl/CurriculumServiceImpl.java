package com.business.API.service.impl;

import com.business.API.commons.dto.CurriculumEntry;
import com.business.API.model.Curriculum;
import com.business.API.repository.CurriculumRepository;
import com.business.API.service.CurriculumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    CurriculumRepository curriculumRepository;

    @Override
    public void createCurriculum(CurriculumEntry request) {
        Curriculum curriculum = mapper.map(request, Curriculum.class);
        curriculumRepository.save(curriculum);
    }

    public Optional<Curriculum> getCurriculumById(long id){
        return curriculumRepository.findById(id);
    }

    public Curriculum putCurriculum(long id, CurriculumEntry request){
        Optional<Curriculum> curriculumData = curriculumRepository.findById(id);
        if(curriculumData.isPresent()){
            Curriculum curriculumNewData = curriculumData.get();
            curriculumNewData.setAddress(request.getAddress());

            return curriculumRepository.save(curriculumNewData);
        }
        return null;
    }

    public void deleteCurriculum(long id){curriculumRepository.deleteById(id);}
}
