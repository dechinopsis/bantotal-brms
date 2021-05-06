package com.dlya.btbrms.flow.schema.step;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowStepStart extends BtFlowStep {
    @JsonProperty("startAt")
    private String startAt;
}
