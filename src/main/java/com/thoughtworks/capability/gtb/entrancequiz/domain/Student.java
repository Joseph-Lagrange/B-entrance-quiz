package com.thoughtworks.capability.gtb.entrancequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wudibin
 * 2020/10/27
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String name;

}
