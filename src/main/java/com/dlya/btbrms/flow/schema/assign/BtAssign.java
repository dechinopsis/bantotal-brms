package com.dlya.btbrms.flow.schema.assign;

import com.dlya.btbrms.flow.schema.enums.BtEAssignType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "assignType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtAssignResource.class, name = "resource"),
        @JsonSubTypes.Type(value = BtAssignScalarConst.class, name = "const"),
        @JsonSubTypes.Type(value = BtAssignExpression.class, name = "expression")
})
public abstract class BtAssign {
    @JsonProperty("assignType")
    private BtEAssignType assignType;
}
