package com.dlya.btbrms.flow.schema.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEAssignResourceType {
    @JsonProperty("var")
    VARIABLE_CONSTANT,
    @JsonProperty("row_field")
    RECORD_FIELD
}
