package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class BtFlowDefinition {
    @JsonProperty("steps")
    private Map<String, BtStep> flowSteps;


}
