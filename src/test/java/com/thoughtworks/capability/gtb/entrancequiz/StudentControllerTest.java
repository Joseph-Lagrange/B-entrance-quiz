package com.thoughtworks.capability.gtb.entrancequiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.model.addStudent.AddStudentRequest;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wudibin
 * 2020/10/27
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentRepository studentRepository;

    private String addStudentRequestContent;

    @BeforeEach
    void setUp() throws Exception {
        studentRepository.deleteAll();
        ObjectMapper objectMapper = new ObjectMapper();
        AddStudentRequest addStudentRequest = AddStudentRequest.builder()
                .name("太乙真人")
                .build();
        addStudentRequestContent = objectMapper.writeValueAsString(addStudentRequest);
    }

    @Test
    @Order(1)
    public void should_add_student_when_param_correct() throws Exception {
        mockMvc.perform(post("/student")
                .content(addStudentRequestContent)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        assertEquals(1, studentRepository.findAll().size());
    }

}
