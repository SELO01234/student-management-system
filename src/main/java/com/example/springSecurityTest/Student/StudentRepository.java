package com.example.springSecurityTest.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student WHERE email = ? ", nativeQuery = true)
    Optional<Student> findStudentByEmail(String email);

    @Query(value = "SELECT * FROM student ORDER BY id", nativeQuery = true)
    List<Student> findStudentById();
}
