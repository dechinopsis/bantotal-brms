package com.dlya.btbrms.flow.schema.step;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BtFlowStepLabeled extends BtFlowStep {
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
}
