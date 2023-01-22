package com.exp.db.controller;

import com.exp.db.entity.Passport;
import com.exp.db.entity.Student;
import com.exp.db.repository.PassportRepository;
import com.exp.db.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passport")
@Slf4j
public class PassportController {

    @Autowired
    private PassportRepository passportRepository;

    @PostMapping("/create")
    public Passport createStudent(@RequestBody Passport passport){
        passportRepository.save(passport);
        return passport;
    }

    @GetMapping("/{id}")
    public Optional<Passport> getPassport(@PathVariable String id){
        Optional<Passport> passport = passportRepository.findById(id);
        log.info("Passport :: getPassportById : {}",passport.get().getStudent());
        return passport;
    }
}
