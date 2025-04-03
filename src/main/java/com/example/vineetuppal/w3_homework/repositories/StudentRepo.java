package com.example.vineetuppal.w3_homework.repositories;

import com.example.vineetuppal.w3_homework.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {
}
