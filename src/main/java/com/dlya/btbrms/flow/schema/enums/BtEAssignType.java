package com.dlya.btbrms.flow.schema.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEAssignType {
    @JsonProperty("resource")
    RESOURCE,
    @JsonProperty("const")
    CONSTANT,
    @JsonProperty("expression")
    EXPRESSION
}
