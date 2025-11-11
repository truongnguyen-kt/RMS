package com.blues.iamservice.config.exception;

import com.blues.common.env.enums.PlatformResponseCode;
import com.blues.common.env.exception.BaseException;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message);
        this.code = PlatformResponseCode.NOT_FOUND.getCode();
    }
}
