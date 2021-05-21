package com.dlya.btbrms.flow.converter;

import com.dlya.btbrms.flow.schema.step.BtFlowStepSequential;

public class BtScriptConverterDrools extends BtScriptConverter {
    public BtScriptConverterDrools(BtConverterBuilder builder) {
        super(builder);
    }

    @Override
    public void evaluateSequential(BtFlowStepSequential seqStep, StringBuilder script) {

    }


}
