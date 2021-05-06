package com.dlya.btbrms.flow.schema.resouce;

import com.dlya.btbrms.flow.schema.assign.BtAssign;
import com.dlya.btbrms.flow.schema.assign.BtAssignScalarConst;
import com.dlya.btbrms.flow.schema.enums.BtEScalarPrimitiveType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceConstant extends BtFlowResource {
    @JsonProperty("dataType")
    private BtEScalarPrimitiveType dataType;
    @JsonProperty("value")
    private BtAssignScalarConst value;
}
