package com.thoughtworks.capability.gtb.entrancequiz.model.addStudent;

import lombok.*;

/**
 * Created by wudibin
 * 2020/10/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentRequest {

    @NonNull
    private String name;

}
