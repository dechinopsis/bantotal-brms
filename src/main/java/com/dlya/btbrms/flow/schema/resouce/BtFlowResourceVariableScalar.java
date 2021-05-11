package com.dlya.btbrms.flow.schema.resouce;

import com.dlya.btbrms.flow.schema.reference.BtReferenceValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceVariableScalar extends BtFlowResourceVariable {
    @JsonProperty("in")
    private Boolean in;
    @JsonProperty("out")
    private Boolean out;
    @JsonProperty("hasDefault")
    private Boolean hasDefault;
    @JsonProperty("defaultValue")
    private BtReferenceValue value;
}
