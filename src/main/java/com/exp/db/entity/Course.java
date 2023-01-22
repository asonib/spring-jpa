package com.exp.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String course_id;
    private String name;
    private String course_description;

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties("course")
    private List<Review> reviews = new ArrayList<>();

    public Course() {
    }

    public Course(String course_id, String name, String course_description) {
        this.course_id = course_id;
        this.name = name;
        this.course_description = course_description;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
