package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.google.common.collect.Lists;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;

import java.util.LinkedList;
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

    /**
     * init data
     * @return List<Student>
     */
    public List<Student> addData2DB() {
        LinkedList<Student> students = Lists.newLinkedList();
        students.add(Student.builder()
                .name("鲁班七号")
                .build());
        students.add(Student.builder()
                .name("太乙真人")
                .build());
        students.add(Student.builder()
                .name("成吉思汗")
                .build());
        students.add(Student.builder()
                .name("花木兰")
                .build());
        students.add(Student.builder()
                .name("雅典娜")
                .build());
        students.add(Student.builder()
                .name("钟无艳")
                .build());
        students.add(Student.builder()
                .name("白起")
                .build());
        students.add(Student.builder()
                .name("芈月")
                .build());
        studentRepository.saveAll(students);
        return students;
    }
}
