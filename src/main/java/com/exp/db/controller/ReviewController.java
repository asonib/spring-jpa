package com.exp.db.controller;

import com.exp.db.entity.Course;
import com.exp.db.entity.Review;
import com.exp.db.repository.CourseRepository;
import com.exp.db.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/create/{course_id}")
    public Review createCourse(@RequestBody Review review, @PathVariable String course_id) throws Exception {
        Optional<Course> course = courseRepository.findById(course_id);
        if(course.isEmpty()){
            throw new Exception("course id invalid");
        }
        course.get().addReview(review);
        review.setCourse(course.get());
        reviewRepository.save(review);
        return review;
    }

    @GetMapping("/{id}")
    public Optional<Review> getReview(@PathVariable String id){
        Optional<Review> review = reviewRepository.findById(id);
        return review;
    }

}
