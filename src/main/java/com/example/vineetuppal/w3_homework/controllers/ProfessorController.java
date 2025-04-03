package com.example.vineetuppal.w3_homework.controllers;

import com.example.vineetuppal.w3_homework.entities.ProfessorEntity;
import com.example.vineetuppal.w3_homework.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorService.createNewProfessor(professorEntity);
    }

    @PutMapping(path = "/{professorId}/student/{studentId}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long professorId, @PathVariable Long studentId){
        return professorService.assignStudentToProfessor(professorId,studentId);
    }
}
