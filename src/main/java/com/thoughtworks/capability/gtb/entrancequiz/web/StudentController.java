package com.thoughtworks.capability.gtb.entrancequiz.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.capability.gtb.entrancequiz.common.constant.Constant;
import com.thoughtworks.capability.gtb.entrancequiz.common.errors.ErrorCode;
import com.thoughtworks.capability.gtb.entrancequiz.common.exceptions.BadRequestException;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.model.addStudent.AddStudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.model.divideStudents.DivideStudentsResponse;
import com.thoughtworks.capability.gtb.entrancequiz.model.getStudents.GetStudentsResponse;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // TODO GTB-知识点: - 建议使用构造方法注入bean
    // TODO GTB-工程实践: - 建议使用private，遵循最小访问原则
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody @Valid AddStudentRequest request) {
        studentService.save(request.getName());
    }

    // TODO GTB-知识点: - 状态码为200时，可以省略@ResponseStatus注解
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public GetStudentsResponse getStudents() {
        List<Student> students = studentService.findAll();
        return GetStudentsResponse.builder()
                .students(students)
                .build();
    }

    @GetMapping("/student/divide")
    @ResponseStatus(HttpStatus.OK)
    public DivideStudentsResponse divideStudents() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            students = studentService.addData2DB();
            // TODO GTB-工程实践: - 及时清理无用代码
            //throw new BadRequestException(ErrorCode.STUDENTS_IS_EMPTY);
        }
        int sequence = 1;
        TreeMap<Integer, List<Student>> group = Maps.newTreeMap();
        // TODO GTB-知识点: + 使用了Collections.shuffle()
        Collections.shuffle(students);
        for (Student s : students) {
            if (sequence % Constant.GROUP_NUMBER == 0) {
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
