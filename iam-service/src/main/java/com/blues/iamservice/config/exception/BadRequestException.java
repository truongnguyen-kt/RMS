package com.blues.iamservice.config.exception;

import com.blues.common.env.enums.PlatformResponseCode;
import com.blues.common.env.exception.BaseException;
import lombok.NonNull;

public class BadRequestException extends BaseException {
    public BadRequestException(@NonNull String message) {
        super(message);
        this.code = PlatformResponseCode.BAD_REQUEST.getCode();
    }
}
