package com.thoughtworks.capability.gtb.entrancequiz.common.exceptions;

import com.thoughtworks.capability.gtb.entrancequiz.common.errors.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wudibin
 * 2020/10/27
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpException {

    public BadRequestException(ErrorCode code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public BadRequestException(ErrorCode code) {
        super(code);
    }

    public BadRequestException(ErrorCode code, String message) {
        super(code, message);
    }

}
