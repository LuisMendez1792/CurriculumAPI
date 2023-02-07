package com.business.API.controller;

import com.business.API.commons.dto.CurriculumEntry;
import com.business.API.model.Curriculum;
import com.business.API.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    CurriculumService curriculumService;

    @GetMapping(value = "/getCurriculumById/{id}")
    @ResponseBody

    public Optional<Curriculum>getCurriculum(@PathVariable(name = "id") long id){return curriculumService.getCurriculumById(id);}

    @PostMapping(value = "/createCurriculum", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCurriculum(@RequestBody CurriculumEntry request ){
        curriculumService.createCurriculum(request);
    }

    @PutMapping(value = "/putCurriculum/{id}")
    @ResponseBody
    public Curriculum putCurriculum(@PathVariable("id") long id, @RequestBody CurriculumEntry request){
        return curriculumService.putCurriculum(id, request);
    }

    @DeleteMapping(value = "/deleteCurriculum/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCurriculum(@PathVariable("id") long id){
        curriculumService.deleteCurriculum(id);
    }

    @GetMapping(value = "/version")
    public String getVersion(){return "1.0";}



}
