package com.exp.db.controller;

import com.exp.db.entity.Course;
import com.exp.db.entity.Passport;
import com.exp.db.repository.CourseRepository;
import com.exp.db.repository.PassportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course){
        courseRepository.save(course);
        return course;
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        Optional<Course> course = courseRepository.findById(id);
        return course;
    }

    @GetMapping
    public Optional<List<Course>> getAllCourses(){
        Optional<List<Course>> course = Optional.of(courseRepository.findAll());
        return course;
    }
}
