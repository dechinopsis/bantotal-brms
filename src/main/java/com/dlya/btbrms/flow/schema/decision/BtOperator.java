package com.dlya.btbrms.flow.schema.decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtOperator {
    //Generic
    @JsonProperty("eq")
    EQUALS,
    @JsonProperty("not")
    DOES_NOT_EQUALS,

    //Numeric, date and datetime
    @JsonProperty("gt")
    GREATER_THAN,
    @JsonProperty("lt")
    LESS_THAN,
    @JsonProperty("gte")
    GREATER_OR_EQUAL_THAN,
    @JsonProperty("lte")
    LESS_OR_EQUAL_THAN,

    //Text
    @JsonProperty("contains")
    CONTAINS,
    @JsonProperty("starts")
    STARTS_WITH,
    @JsonProperty("ends")
    ENDS_WITH,
    @JsonProperty("blank")
    IS_BLANK,

    //Boolean
    @JsonProperty("true")
    IS_TRUTHY,
    @JsonProperty("false")
    IS_FALSY,
}
