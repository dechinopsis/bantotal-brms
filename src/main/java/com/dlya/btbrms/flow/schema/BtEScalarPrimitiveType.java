package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEScalarPrimitiveType {
    @JsonProperty("number")
    NUMBER,
    @JsonProperty("amount")
    AMOUNT,
    @JsonProperty("rate")
    RATE,
    @JsonProperty("bool")
    BOOLEAN,
    @JsonProperty("text")
    TEXT,
    @JsonProperty("date")
    DATE,
    @JsonProperty("datetime")
    DATE_TIME
}
