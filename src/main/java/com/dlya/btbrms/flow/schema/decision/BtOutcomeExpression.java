package com.dlya.btbrms.flow.schema.decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtOutcomeExpression extends BtOutcome {
    @JsonProperty("expression")
    private String expression;
}
