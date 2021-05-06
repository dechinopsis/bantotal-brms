package com.dlya.btbrms.flow.schema.step;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BtFlowStepSequential extends BtFlowStepLabeled {
    @JsonProperty("next")
    private String next;
}
