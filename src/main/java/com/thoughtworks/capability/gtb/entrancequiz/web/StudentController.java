package com.thoughtworks.capability.gtb.entrancequiz.web;

import com.thoughtworks.capability.gtb.entrancequiz.model.addStudent.AddStudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wudibin
 * 2020/10/27
 */
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody @Valid AddStudentRequest request) {
        studentService.save(request.getName());
    }

}
