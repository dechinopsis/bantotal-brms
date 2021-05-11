package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.schema.decision.BtOutcome;

import java.util.List;
public class BtFlowStepDecision extends BtFlowStepLabeled {
    private String defaultOutCome;
    private List<BtOutcome> outcomes;
}
