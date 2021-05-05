package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceVariableScalar extends BtFlowResourceVariable {
    @JsonProperty("in")
    private Boolean in;
    @JsonProperty("out")
    private Boolean out;
    @JsonProperty("hasDefault")
    private Boolean hasDefault;
    //TODO: define assignment
}
