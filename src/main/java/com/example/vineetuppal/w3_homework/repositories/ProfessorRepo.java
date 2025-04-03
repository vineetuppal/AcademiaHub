package com.example.vineetuppal.w3_homework.repositories;

import com.example.vineetuppal.w3_homework.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<ProfessorEntity,Long> {
}
