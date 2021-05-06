package com.dlya.btbrms.flow.schema.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEFlowResourceType {
    @JsonProperty("const")
    CONSTANT,
    @JsonProperty("record")
    RECORD,
    @JsonProperty("var")
    SCALAR_VARIABLE,
    @JsonProperty("var[]")
    ARRAY_VARIABLE
}
