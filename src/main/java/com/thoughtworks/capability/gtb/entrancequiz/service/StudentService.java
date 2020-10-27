package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;

import java.util.List;

/**
 * Created by wudibin
 * 2020/10/27
 */
public class StudentService {

    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(String name) {
        Student student = Student.builder()
                .name(name)
                .build();
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
