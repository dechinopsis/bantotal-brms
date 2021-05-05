package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceConstant extends BtFlowResource {
    @JsonProperty("dataType")
    private BtEScalarPrimitiveType dataType;
    //TODO: define assignment
}
