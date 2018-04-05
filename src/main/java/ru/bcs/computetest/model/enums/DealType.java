package ru.bcs.computetest.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DealType {

    BUY("buy"),
    SELL("sell");

    private String value;

    DealType(String title) {
        this.value = title;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
