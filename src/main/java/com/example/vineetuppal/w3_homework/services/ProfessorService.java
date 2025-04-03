package com.example.vineetuppal.w3_homework.services;

import com.example.vineetuppal.w3_homework.entities.ProfessorEntity;
import com.example.vineetuppal.w3_homework.entities.StudentEntity;
import com.example.vineetuppal.w3_homework.repositories.ProfessorRepo;
import com.example.vineetuppal.w3_homework.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepo professorRepo;
    private final StudentRepo studentRepo;

    public ProfessorService(ProfessorRepo professorRepo, StudentRepo studentRepo) {
        this.professorRepo = professorRepo;
        this.studentRepo = studentRepo;
    }

    public ProfessorEntity getProfessorById(Long professorId) {
        return professorRepo.findById(professorId).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepo.save(professorEntity);
    }

    public ProfessorEntity assignStudentToProfessor(Long professorId, Long studentId) {
        Optional <ProfessorEntity> professorEntity = professorRepo.findById(professorId);
        Optional <StudentEntity> studentEntity = studentRepo.findById(studentId);

        return professorEntity.flatMap(professor ->
                studentEntity.map(student -> {

                    professor.getStudents().add(student);
                    professorRepo.save(professor);

                    student.getProfessors().add(professor);
                    return professor;
                })).orElse(null);
    }
}
