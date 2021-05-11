package com.dlya.btbrms.flow.schema.resouce;

import com.dlya.btbrms.flow.schema.reference.BtReferenceScalarConst;
import com.dlya.btbrms.flow.schema.types.BtEScalarPrimitiveType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceConstant extends BtFlowResource {
    @JsonProperty("dataType")
    private BtEScalarPrimitiveType dataType;
    @JsonProperty("value")
    private BtReferenceScalarConst value;
}
