package com.dlya.btbrms.flow.schema.assign;

import com.dlya.btbrms.flow.schema.reference.BtReferenceResource;
import com.dlya.btbrms.flow.schema.reference.BtReferenceValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignEntry {
    @JsonProperty("target")
    private BtReferenceResource target;
    @JsonProperty("source")
    private BtReferenceValue source;
}
