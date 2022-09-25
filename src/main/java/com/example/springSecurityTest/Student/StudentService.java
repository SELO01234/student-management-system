package com.example.springSecurityTest.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getStudent(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email was taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);

        if(exists == true){
            studentRepository.deleteById(studentId);
        }
        else{
            throw new IllegalStateException("Student with id " + studentId + " does not exists");
        }
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student) {

        Student student2 = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with id " + studentId + " does not exists")
        );

        student2.setFirstName(student.getFirstName());
        student2.setLastName(student.getLastName());
        student2.setEmail(student.getEmail());

        studentRepository.save(student2);
        return student;
    }

    public Student getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student with id " + studentId + " does not exists")
        );

        return student;
    }

    public Long getAllStudentList() {
        List<Student> studentList=studentRepository.findAll();
        return studentList.stream().count();
    }
}
