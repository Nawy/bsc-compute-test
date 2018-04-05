package ru.bcs.computetest.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PositionType {
    SECURITY("security"),
    CURRENCY("currency");

    private String value;

    PositionType(String title) {
        this.value = title;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
