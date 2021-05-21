package com.dlya.btbrms.flow.converter;


import com.dlya.btbrms.flow.schema.BtFlowDefinition;

public interface BtFlowStepValidator {
    void validate(BtFlowDefinition flow) throws BtFlowValidatorException;
}
