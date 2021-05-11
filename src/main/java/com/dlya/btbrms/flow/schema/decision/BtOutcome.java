package com.dlya.btbrms.flow.schema.decision;

import com.dlya.btbrms.flow.schema.types.BtEDecisionOutcomeType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtOutcomeWResources.class, name = "and"),
        @JsonSubTypes.Type(value = BtOutcomeWResources.class, name = "or"),
        @JsonSubTypes.Type(value = BtOutcomeCustomCondition.class, name = "custom"),
        @JsonSubTypes.Type(value = BtOutcomeExpression.class, name = "expression")
})
public abstract class BtOutcome {
    @JsonProperty("type")
    private BtEDecisionOutcomeType type;
    @JsonProperty("outCome")
    private String outCome;
    @JsonProperty("label")
    private String label;
    @JsonProperty("apiName")
    private String apiName;
}
