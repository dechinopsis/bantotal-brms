package com.dlya.btbrms.flow.converter;

import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.dlya.btbrms.flow.schema.step.BtFlowStepAssignment;
import com.dlya.btbrms.flow.schema.step.BtFlowStepSequential;
import com.dlya.btbrms.flow.schema.step.BtFlowStepStart;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

public class BtFlowValidator {
    public static final String DEFINITION_NULL = "Flow schema cannot be null";
    public static final String START_NULL = "Start cannot be null";
    public static final String START_AT_NULL = "First step cannot be null";
    public static final String NO_RESOURCES = "Resources cannot be null";
    public static final String NO_STEPS = "Steps cannot be null";
    public static final String STEP_NOT_FOUND = "Step \"%s\" not found";

    public static void validate(BtFlowDefinition flow) throws BtFlowValidatorException {
        if (flow == null) {
            throw new BtFlowValidatorException(DEFINITION_NULL);
        }
        if (MapUtils.isEmpty(flow.getFlowResources())) {
            throw new BtFlowValidatorException(NO_RESOURCES);
        }
        if (MapUtils.isEmpty(flow.getFlowSteps())) {
            throw new BtFlowValidatorException(NO_STEPS);
        }
        if (flow.getStart() == null) {
            throw new BtFlowValidatorException(START_NULL);
        }
    }

    public static void validate(BtFlowDefinition flow, BtFlowStepStart start) throws BtFlowValidatorException {
        String startAt = start.getStartAt();
        if (StringUtils.isBlank(startAt)) {
            throw new BtFlowValidatorException(START_AT_NULL);
        }
        if (!flow.existsStep(startAt)) {
            throw new BtFlowValidatorException(String.format(
                    STEP_NOT_FOUND,
                    startAt
            ));
        }
    }

    public static void validate(BtFlowDefinition flow, BtFlowStepSequential step) throws BtFlowValidatorException {
        String next = step.getNext();
        if (StringUtils.isBlank(next)) {
            return;
        }
        if (!flow.existsStep(next)) {
            throw new BtFlowValidatorException(String.format(
                    STEP_NOT_FOUND,
                    next
            ));
        }
    }

    public static void validate(BtFlowDefinition flow, BtFlowStepAssignment step) throws BtFlowValidatorException {
    }
}
