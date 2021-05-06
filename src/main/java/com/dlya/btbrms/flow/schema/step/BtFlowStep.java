package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.schema.enums.BtEFlowStepType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtFlowStepStart.class, name = "start"),
        @JsonSubTypes.Type(value = BtFlowStepAssignment.class, name = "assignment")
})
public abstract class BtFlowStep {
    @JsonProperty("apiName")
    private String apiName;
    @JsonProperty("type")
    private BtEFlowStepType type;
}
