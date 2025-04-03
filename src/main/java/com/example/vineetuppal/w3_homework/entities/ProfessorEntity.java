package com.example.vineetuppal.w3_homework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "professor")
    private Set<SubjectEntity> subjects;

    @ManyToMany
    @JoinTable(name = "professor_students_mapping",
                joinColumns = @JoinColumn(name = "professor_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<StudentEntity> students;
}
