package com.dlya.btbrms.flow.schema.assign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignExpression extends BtAssign {
    @JsonProperty("expression")
    private String expression;
}
