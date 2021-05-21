package com.dlya.btbrms.flow.converter;

import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.dlya.btbrms.flow.schema.step.BtFlowStep;
import com.dlya.btbrms.flow.schema.step.BtFlowStepSequential;
import com.dlya.btbrms.flow.schema.step.BtFlowStepStart;


public abstract class BtScriptConverter {
    private final BtFlowDefinition flow;

    public BtScriptConverter(BtConverterBuilder builder) {
        flow = builder.getFlowDefinition();
    }

    public String generate() throws BtFlowValidatorException {
        BtFlowValidator.validate(flow);

        BtFlowStepStart start = flow.getStart();
        start.validate(flow);

        BtFlowStep root = flow.getStep(start.getStartAt());
        StringBuilder script = new StringBuilder();
        generateInternal(root, script, 1);

        return script.toString();
    }

    private void generateInternal(BtFlowStep root, StringBuilder script, int treeLevel) throws BtFlowValidatorException {
        BtFlowStep step = root;
        while (step instanceof BtFlowStepSequential) {
            BtFlowStepSequential seqStep = (BtFlowStepSequential) step;
            seqStep.validate(flow);
            evaluateSequential(seqStep, script);
            step = flow.getStep(seqStep.getNext());
        }
    }

    public abstract void evaluateSequential(BtFlowStepSequential seqStep, StringBuilder script);
}
