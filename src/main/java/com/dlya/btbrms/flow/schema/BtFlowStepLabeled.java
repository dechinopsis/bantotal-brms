package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BtFlowStepLabeled extends BtFlowStep {
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
}
