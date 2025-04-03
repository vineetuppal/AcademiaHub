package com.example.vineetuppal.w3_homework.services;

import com.example.vineetuppal.w3_homework.entities.StudentEntity;
import com.example.vineetuppal.w3_homework.entities.SubjectEntity;
import com.example.vineetuppal.w3_homework.repositories.StudentRepo;
import com.example.vineetuppal.w3_homework.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;

    public StudentService(StudentRepo studentRepo, SubjectRepo subjectRepo) {
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

    public StudentEntity getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepo.save(studentEntity);
    }

    public StudentEntity assignSubjectToStudent(Long studentId, Long subjectId) {
        Optional <StudentEntity> studentEntity = studentRepo.findById(studentId);
        Optional <SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);

        return studentEntity.flatMap(student ->
                subjectEntity.map(subject-> {

                    student.getSubjects().add(subject);
                    studentRepo.save(student);

                    subject.getStudents().add(student);
                    return student;
                })).orElse(null);
    }
}
