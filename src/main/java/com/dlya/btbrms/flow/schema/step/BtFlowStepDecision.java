package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.schema.decision.BtOutcome;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class BtFlowStepDecision extends BtFlowStepLabeled {
    @JsonProperty("defaultOutCome")
    private String defaultOutCome;
    @JsonProperty("outcomes")
    private List<BtOutcome> outcomes;
}
