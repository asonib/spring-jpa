package com.exp.db.controller;

import com.exp.db.entity.Course;
import com.exp.db.entity.Student;
import com.exp.db.repository.CourseRepository;
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
    private CourseRepository courseRepository;

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

    @GetMapping("/map/{studentId}/to/{courseId}")
    public Student mapStudentToCourse(@PathVariable String studentId, @PathVariable String courseId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);

        if(student.isEmpty() || course.isEmpty()){
            throw new Exception("unable to map. please check the id(s)");
        }

        student.get().addCourse(course.get());
        course.get().addStudents(student.get());

        //save the owning side of the ManyToMany Relationship
        studentRepository.save(student.get());
        return student.get();
    }
}
