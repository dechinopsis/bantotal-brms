package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("assignment")
public class BtMetadataTypeAssignment extends BtMetadataTypeBase {
    @JsonProperty("assignments")
    private List<BtMetadataAssignmentDef> assignmentsList;
}
