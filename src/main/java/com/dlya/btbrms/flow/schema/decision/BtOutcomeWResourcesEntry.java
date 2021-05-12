package com.dlya.btbrms.flow.schema.decision;

import com.dlya.btbrms.flow.schema.reference.BtReferenceResource;
import com.dlya.btbrms.flow.schema.reference.BtReferenceValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtOutcomeWResourcesEntry {
    @JsonProperty("resource")
    private BtReferenceResource resource;
    @JsonProperty("operator")
    private BtOperator operator;
    @JsonProperty("value")
    private BtReferenceValue value;
}
