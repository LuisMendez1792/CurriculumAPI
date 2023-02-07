package com.business.API.service;

import com.business.API.commons.dto.CurriculumEntry;
import com.business.API.model.Curriculum;

import java.util.Optional;

public interface CurriculumService {

    void createCurriculum(CurriculumEntry request);

    Optional<Curriculum> getCurriculumById(long Id);

    Curriculum putCurriculum(long id, CurriculumEntry request);

    void deleteCurriculum(long id);
}
