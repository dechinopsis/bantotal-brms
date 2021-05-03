package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtMetadataAssignmentDef {
    @JsonProperty("variable")
    private String variableApiName;
    @JsonProperty("type")
    private BtAssignmentType assignmentType;
    @JsonProperty("value")
    private String value;
}
