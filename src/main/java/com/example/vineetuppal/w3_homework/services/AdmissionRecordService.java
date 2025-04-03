package com.example.vineetuppal.w3_homework.services;

import com.example.vineetuppal.w3_homework.entities.AdmissionRecordEntity;
import com.example.vineetuppal.w3_homework.entities.StudentEntity;
import com.example.vineetuppal.w3_homework.repositories.AdmissionRecordRepo;
import com.example.vineetuppal.w3_homework.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;

    public AdmissionRecordService(AdmissionRecordRepo admissionRecordRepo, StudentRepo studentRepo) {
        this.admissionRecordRepo = admissionRecordRepo;
        this.studentRepo = studentRepo;
    }

    public AdmissionRecordEntity getAdmissionRecordById(Long admissionId) {
        return admissionRecordRepo.findById(admissionId).orElse(null);
    }


    public AdmissionRecordEntity createNewAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepo.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity assignStudentToAdmissionRecord(Long admissionId, Long studentId) {
        Optional <AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepo.findById(admissionId);
        Optional <StudentEntity> studentEntity = studentRepo.findById(studentId);

        return admissionRecordEntity.flatMap(admission ->
                studentEntity.map(student->{
                admission.setStudent(student);
                return admissionRecordRepo.save(admission);
        })).orElse(null);
    }
}
