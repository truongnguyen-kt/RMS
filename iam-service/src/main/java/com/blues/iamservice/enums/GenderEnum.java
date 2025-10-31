package com.blues.iamservice.enums;

import lombok.Getter;

@Getter
public enum GenderEnum {
    MALE("MALE"),
    FEMALE("FEMALE");
    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }
}
