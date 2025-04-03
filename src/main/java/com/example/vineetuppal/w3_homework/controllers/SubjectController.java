package com.example.vineetuppal.w3_homework.controllers;

import com.example.vineetuppal.w3_homework.entities.SubjectEntity;
import com.example.vineetuppal.w3_homework.repositories.SubjectRepo;
import com.example.vineetuppal.w3_homework.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectService.createNewSubject(subjectEntity);
    }

    @PutMapping(path = "/{subjectId}/professor/{professorId}")
    public SubjectEntity assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId){
        return subjectService.assignProfessorToSubject(subjectId,professorId);
    }
}
