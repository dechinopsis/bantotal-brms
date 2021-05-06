package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.schema.assign.BtAssignEntry;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BtFlowStepAssignment extends BtFlowStepSequential {
    @JsonProperty("assignments")
    private List<BtAssignEntry> assignments;
}
