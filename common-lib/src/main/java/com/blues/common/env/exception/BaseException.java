package com.blues.common.env.exception;

import com.blues.common.env.config.LocalizedMessageResolver;
import com.blues.common.env.enums.PlatformResponseCode;
import com.blues.common.env.response.BaseResponseCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class BaseException extends RuntimeException {
    protected String code;
    protected Object[] arguments;

    public BaseException(@NonNull BaseResponseCode responseCode) {
        super(responseCode.getMessage());
        if (responseCode == null) {
            throw new NullPointerException("responseCode is marked non-null but is null");
        } else {
            this.code = responseCode.getCode();
            this.arguments = new Object[0];
        }
    }

    public BaseException(@NonNull BaseResponseCode responseCode, final Object... arguments) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.arguments = arguments;
    }

    public BaseException(@NonNull String message) {
        super(message);
        this.code = PlatformResponseCode.INTERNAL_SERVER_ERROR.getCode();
        this.arguments = new Object[0];
    }

    public BaseException(@NonNull String message, final Object... arguments) {
        super(message);
        this.code = PlatformResponseCode.INTERNAL_SERVER_ERROR.getCode();
        this.arguments = arguments;
    }

    @Override
    public String getMessage() {
        String key = super.getMessage();
        return LocalizedMessageResolver.resolve(key, arguments);
    }
}
