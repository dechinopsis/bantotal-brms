package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BtAssignmentEntry {
    @JsonProperty("variable")
    private String variableApiName;
    @JsonProperty("type")
    private BtEAssignmentEntryType assignmentType;
    @JsonProperty("value")
    private String value;

    public String getVariableApiName() {
        return variableApiName;
    }

    public BtEAssignmentEntryType getAssignmentType() {
        return assignmentType;
    }

    public String getValue() {
        return value;
    }
}
