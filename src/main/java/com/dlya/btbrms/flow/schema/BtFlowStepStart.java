package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowStepStart extends BtFlowStep {
    @JsonProperty("startAt")
    private String startAt;
}
