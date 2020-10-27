package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wudibin
 * 2020/10/27
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
