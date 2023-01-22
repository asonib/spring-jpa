package com.exp.db.controller;

import com.exp.db.entity.Student;
import com.exp.db.repository.PassportRepository;
import com.exp.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PassportRepository passportRepository;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        passportRepository.save(student.getPassport());
        studentRepository.save(student);
        return student;
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable String id){
        return studentRepository.findById(id);
    }
}
