package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtAssignmentType {
    @JsonProperty("constant")
    CONSTANT,
    @JsonProperty("variable")
    VARIABLE,
    @JsonProperty("expression")
    EXPRESSION
}
