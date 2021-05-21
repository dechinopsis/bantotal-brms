package com.dlya.btbrms.flow.schema;

import com.dlya.btbrms.flow.schema.resouce.BtFlowResource;
import com.dlya.btbrms.flow.schema.step.BtFlowStep;
import com.dlya.btbrms.flow.schema.step.BtFlowStepStart;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class BtFlowDefinition {
    private static final String START = "start";

    @JsonProperty("flowSteps")
    private Map<String, BtFlowStep> flowSteps;
    @JsonProperty("flowResources")
    private Map<String, BtFlowResource> flowResources;

    public Map<String, BtFlowStep> getFlowSteps() {
        return flowSteps;
    }

    public Map<String, BtFlowResource> getFlowResources() {
        return flowResources;
    }

    public BtFlowStepStart getStart() {
        return (BtFlowStepStart) flowSteps.get(START);
    }

    public BtFlowStep getStep(String apiName) {
        return flowSteps.get(apiName);
    }

    public boolean existsStep(String apiName) {
        return flowSteps.containsKey(apiName);
    }

}
