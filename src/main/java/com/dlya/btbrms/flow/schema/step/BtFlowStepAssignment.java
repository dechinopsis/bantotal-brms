package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.converter.BtFlowValidator;
import com.dlya.btbrms.flow.converter.BtFlowValidatorException;
import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.dlya.btbrms.flow.schema.assign.BtAssignEntry;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BtFlowStepAssignment extends BtFlowStepSequential {
    @JsonProperty("assignments")
    private List<BtAssignEntry> assignments;

    public List<BtAssignEntry> getAssignments() {
        return assignments;
    }

    @Override
    public void validate(BtFlowDefinition flow) throws BtFlowValidatorException {
        super.validate(flow);
        BtFlowValidator.validate(flow, this);
    }
}
