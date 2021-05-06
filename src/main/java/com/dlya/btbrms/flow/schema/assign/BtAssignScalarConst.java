package com.dlya.btbrms.flow.schema.assign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignScalarConst extends BtAssign {
    @JsonProperty("value")
    private String value;
}
