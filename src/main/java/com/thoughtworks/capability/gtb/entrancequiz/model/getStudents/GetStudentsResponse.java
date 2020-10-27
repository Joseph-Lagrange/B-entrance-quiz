package com.thoughtworks.capability.gtb.entrancequiz.model.getStudents;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by wudibin
 * 2020/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentsResponse {

    private List<Student> students;

}
