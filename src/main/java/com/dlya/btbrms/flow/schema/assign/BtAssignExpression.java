package com.dlya.btbrms.flow.schema.assign;

import com.dlya.btbrms.flow.schema.reference.BtReferenceValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignExpression extends BtReferenceValue {
    @JsonProperty("expression")
    private String expression;
}
