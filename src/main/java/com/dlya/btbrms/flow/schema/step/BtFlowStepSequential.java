package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.converter.BtFlowStepValidator;
import com.dlya.btbrms.flow.converter.BtFlowValidator;
import com.dlya.btbrms.flow.converter.BtFlowValidatorException;
import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BtFlowStepSequential extends BtFlowStepLabeled implements BtFlowStepValidator {
    @JsonProperty("next")
    private String next;

    public String getNext() {
        return next;
    }

    @Override
    public void validate(BtFlowDefinition flow) throws BtFlowValidatorException {
        BtFlowValidator.validate(flow, this);
    }
}
