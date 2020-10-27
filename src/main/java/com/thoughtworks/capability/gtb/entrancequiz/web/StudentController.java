package com.thoughtworks.capability.gtb.entrancequiz.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.capability.gtb.entrancequiz.common.errors.ErrorCode;
import com.thoughtworks.capability.gtb.entrancequiz.common.exceptions.BadRequestException;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.model.addStudent.AddStudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.model.divideStudents.DivideStudentsResponse;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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

    @PostMapping("/student/divide")
    @ResponseStatus(HttpStatus.OK)
    public DivideStudentsResponse divideStudents() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            throw new BadRequestException(ErrorCode.STUDENTS_IS_EMPTY);
        }
        int sequence = 1;
        TreeMap<Integer, List<Student>> group = Maps.newTreeMap();
        Collections.shuffle(students);
        for (Student s : students) {
            if (sequence % 7 == 0) {
                sequence = 1;
            }
            if (!group.containsKey(sequence)) {
                group.put(sequence, Lists.newArrayList());
            }
            group.get(sequence).add(s);
            sequence++;
        }
        return DivideStudentsResponse.builder()
                .group(group)
                .build();
    }

}
