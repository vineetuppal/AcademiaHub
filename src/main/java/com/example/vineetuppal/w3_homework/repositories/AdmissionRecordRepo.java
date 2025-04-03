package com.example.vineetuppal.w3_homework.repositories;

import com.example.vineetuppal.w3_homework.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecordEntity,Long> {
}
