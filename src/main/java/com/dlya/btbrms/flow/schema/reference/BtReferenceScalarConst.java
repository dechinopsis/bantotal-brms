package com.dlya.btbrms.flow.schema.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtReferenceScalarConst extends BtReferenceValue {
    @JsonProperty("value")
    private String value;

    public String getValue() {
        return value;
    }
}
