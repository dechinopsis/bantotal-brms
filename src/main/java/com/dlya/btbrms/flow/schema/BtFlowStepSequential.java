package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BtFlowStepSequential extends BtFlowStepLabeled {
    @JsonProperty("next")
    private String next;
}
