package com.dlya.btbrms.flow.schema.decision;

import com.dlya.btbrms.flow.schema.reference.BtReferenceResource;
import com.dlya.btbrms.flow.schema.reference.BtReferenceValue;
import com.dlya.btbrms.flow.schema.types.BtECondOperator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtOutcomeWResourcesEntry {
    @JsonProperty("resource")
    private BtReferenceResource resource;
    @JsonProperty("operator")
    private BtECondOperator operator;
    @JsonProperty("value")
    private BtReferenceValue value;

    public BtReferenceResource getResource() {
        return resource;
    }

    public BtECondOperator getOperator() {
        return operator;
    }

    public BtReferenceValue getValue() {
        return value;
    }
}
