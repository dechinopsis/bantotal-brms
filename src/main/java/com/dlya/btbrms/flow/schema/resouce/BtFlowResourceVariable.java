package com.dlya.btbrms.flow.schema.resouce;

import com.dlya.btbrms.flow.schema.enums.BtEScalarPrimitiveType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceVariable extends BtFlowResource {
    @JsonProperty("dataType")
    private BtEScalarPrimitiveType dataType;
    @JsonProperty("isCollection")
    private Boolean isCollection;
}
