package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BtAssignmentMetadataType extends BtBaseMetadataType {
    @JsonProperty("assignments")
    private List<BtAssignmentEntry> assignmentsList;
}
