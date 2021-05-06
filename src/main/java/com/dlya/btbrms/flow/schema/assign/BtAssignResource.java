package com.dlya.btbrms.flow.schema.assign;

import com.dlya.btbrms.flow.schema.enums.BtEAssignResourceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resourceType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BtAssignResource.class, name = "var"),
        @JsonSubTypes.Type(value = BtAssignResourceRecordField.class, name = "row_field")
})
public class BtAssignResource extends BtAssign {
    @JsonProperty("apiName")
    private String apiName;
    @JsonProperty("resourceType")
    private BtEAssignResourceType resourceType;
}
