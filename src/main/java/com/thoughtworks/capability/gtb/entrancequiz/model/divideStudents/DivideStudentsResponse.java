package com.thoughtworks.capability.gtb.entrancequiz.model.divideStudents;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by wudibin
 * 2020/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DivideStudentsResponse {

    private TreeMap<Integer, List<Student>> group;

}
