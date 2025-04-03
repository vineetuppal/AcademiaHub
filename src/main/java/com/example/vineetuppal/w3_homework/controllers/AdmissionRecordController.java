package com.example.vineetuppal.w3_homework.controllers;

import com.example.vineetuppal.w3_homework.entities.AdmissionRecordEntity;
import com.example.vineetuppal.w3_homework.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission-record")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;


    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping("/{admissionId}")
    public AdmissionRecordEntity getAdmissionRecordById(@PathVariable Long admissionId){
        return admissionRecordService.getAdmissionRecordById(admissionId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.createNewAdmissionRecord(admissionRecordEntity);
    }

    @PutMapping(path = "/{admissionId}/student/{studentId}")
    public AdmissionRecordEntity assignStudentToAdmissionRecord(@PathVariable Long admissionId, @PathVariable Long studentId){
        return admissionRecordService.assignStudentToAdmissionRecord(admissionId,studentId);
    }

}
