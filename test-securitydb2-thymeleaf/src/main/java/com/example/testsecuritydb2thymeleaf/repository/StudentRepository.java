package com.example.testsecuritydb2thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.testsecuritydb2thymeleaf.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
}
