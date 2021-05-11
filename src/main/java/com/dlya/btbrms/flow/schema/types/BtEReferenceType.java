package com.dlya.btbrms.flow.schema.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEReferenceType {
    @JsonProperty("resource")
    RESOURCE,
    @JsonProperty("const")
    CONSTANT,
    @JsonProperty("expression")
    EXPRESSION
}
