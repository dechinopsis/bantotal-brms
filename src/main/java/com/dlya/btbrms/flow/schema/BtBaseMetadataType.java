package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtAssignmentMetadataType.class, name = "assignment")
})
public abstract class BtBaseMetadataType {
    @JsonProperty("type")
    private BtEStepType stepType;
}
