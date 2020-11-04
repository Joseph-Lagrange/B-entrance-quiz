// TODO GTB-工程实践: - 包名应小写
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
// TODO GTB-工程实践: - 类名应避免包含动词
public class AddStudentRequest {

    @NonNull
    private String name;

}
