package com.exp.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    @JsonIgnoreProperties("passport")
    private Student student;

    public Passport() {
    }

    public Passport(String id, String number) {
        Id = id;
        this.number = number;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "Id='" + Id + '\'' +
                ", number='" + number + '\'' +
                ", student=" + student +
                '}';
    }
}
