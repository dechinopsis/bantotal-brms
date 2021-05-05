package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BtFlowStepAssignment extends BtFlowStepSequential {
    @JsonProperty("assignments")
    private List<BtAssignmentEntry> assignments;
}
