package com.dlya.btbrms.flow.schema.resouce;

import com.dlya.btbrms.flow.schema.types.BtEFlowResourceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resourceType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtFlowResourceConstant.class, name = "const"),
        @JsonSubTypes.Type(value = BtFlowResourceRecord.class, name = "record"),
        @JsonSubTypes.Type(value = BtFlowResourceVariableScalar.class, name = "var"),
        @JsonSubTypes.Type(value = BtFlowResourceVariable.class, name = "var[]")
})
public abstract class BtFlowResource {
    @JsonProperty("apiName")
    private String apiName;
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
    @JsonProperty("resourceType")
    private BtEFlowResourceType resourceType;
}
