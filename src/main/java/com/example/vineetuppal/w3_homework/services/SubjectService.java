package com.example.vineetuppal.w3_homework.services;

import com.example.vineetuppal.w3_homework.entities.ProfessorEntity;
import com.example.vineetuppal.w3_homework.entities.SubjectEntity;
import com.example.vineetuppal.w3_homework.repositories.ProfessorRepo;
import com.example.vineetuppal.w3_homework.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepo subjectRepo;
    private final ProfessorRepo professorRepo;

    public SubjectService(SubjectRepo subjectRepo, ProfessorRepo professorRepo) {
        this.subjectRepo = subjectRepo;
        this.professorRepo = professorRepo;
    }

    public SubjectEntity getSubjectById(Long subjectId) {
        return subjectRepo.findById(subjectId).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepo.save(subjectEntity);
    }

    public SubjectEntity assignProfessorToSubject(Long subjectId, Long professorId) {
        Optional <SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);
        Optional <ProfessorEntity> professorEntity = professorRepo.findById(professorId);

        return subjectEntity.flatMap(subject ->
                professorEntity.map(professor -> {
                    subject.setProfessor(professor);
                    subjectRepo.save(subject);

                    professor.getSubjects().add(subject);
                    return subject;
                })).orElse(null);
    }
}
