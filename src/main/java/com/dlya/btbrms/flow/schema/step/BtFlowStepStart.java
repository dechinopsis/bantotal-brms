package com.dlya.btbrms.flow.schema.step;

import com.dlya.btbrms.flow.converter.BtFlowStepValidator;
import com.dlya.btbrms.flow.converter.BtFlowValidator;
import com.dlya.btbrms.flow.converter.BtFlowValidatorException;
import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowStepStart extends BtFlowStep implements BtFlowStepValidator {
    @JsonProperty("startAt")
    private String startAt;

    public String getStartAt() {
        return startAt;
    }

    @Override
    public void validate(BtFlowDefinition flow) throws BtFlowValidatorException {
        BtFlowValidator.validate(flow, this);
    }
}
