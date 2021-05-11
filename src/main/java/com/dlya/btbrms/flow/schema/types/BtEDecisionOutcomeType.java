package com.dlya.btbrms.flow.schema.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtEDecisionOutcomeType {
    @JsonProperty("and")
    AND,
    @JsonProperty("or")
    OR,
    @JsonProperty("custom")
    CUSTOM,
    @JsonProperty("expression")
    EXPRESSION
}
