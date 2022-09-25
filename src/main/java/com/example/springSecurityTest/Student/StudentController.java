package com.example.springSecurityTest.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("count")
    public Long getStudentNumber(){
        return studentService.getAllStudentList();
    }

    @GetMapping("student")
    public Page<Student> getStudent(Pageable pageable){
        return studentService.getStudent(pageable);
    }

    @PostMapping("add")
    public void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("student/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("update/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student){
        student = studentService.updateStudent(studentId, student);
        return student;
    }
}
