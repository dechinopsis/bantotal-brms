package com.dlya.btbrms.flow.schema.reference;

import com.dlya.btbrms.flow.schema.assign.BtAssignExpression;
import com.dlya.btbrms.flow.schema.types.BtEReferenceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtReferenceResource.class, name = "resource"),
        @JsonSubTypes.Type(value = BtReferenceScalarConst.class, name = "const"),
        @JsonSubTypes.Type(value = BtAssignExpression.class, name = "expression")
})
public abstract class BtReferenceValue {
    @JsonProperty("type")
    private BtEReferenceType type;

    public BtEReferenceType getType() {
        return type;
    }
}
