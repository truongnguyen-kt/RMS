package com.blues.iamservice.config.exception;

import com.blues.common.env.enums.PlatformResponseCode;
import com.blues.common.env.exception.BaseException;

public class InternalServerErrorException extends BaseException {
    public InternalServerErrorException(String message) {
        super(message);
        this.code = PlatformResponseCode.INTERNAL_SERVER_ERROR.getCode();
    }
}
