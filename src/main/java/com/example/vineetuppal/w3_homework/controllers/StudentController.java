package com.example.vineetuppal.w3_homework.controllers;

import com.example.vineetuppal.w3_homework.entities.StudentEntity;
import com.example.vineetuppal.w3_homework.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity){
        return studentService.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/subject/{subjectId}")
    public StudentEntity assignSubjectToStudent(@PathVariable Long studentId, @PathVariable Long subjectId){
        return studentService.assignSubjectToStudent(studentId,subjectId);
    }
}
