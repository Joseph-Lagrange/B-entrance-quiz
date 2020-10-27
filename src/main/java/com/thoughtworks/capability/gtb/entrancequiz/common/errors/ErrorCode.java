package com.thoughtworks.capability.gtb.entrancequiz.common.errors;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wudibin
 * 2020/10/27
 */
public enum ErrorCode {

    INVALID_REQUEST(10000, "请求参数错误"),
    STUDENTS_IS_EMPTY(10001, "学员列表为空");

    private static final Set<String> ERROR_CODE_VALUES = ImmutableSet.copyOf(
            Arrays.stream(values()).map(Enum::toString).collect(Collectors.toSet())
    );

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static boolean contains(String code) {
        return ERROR_CODE_VALUES.contains(code);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @JsonValue
    public ErrorMessage toErrorMessage() {
        return new ErrorMessage(code, message, new HashMap<>());
    }

}
