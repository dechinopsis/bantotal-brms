package com.dlya.btbrms.flow.schema.assign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignResourceRecordField extends BtAssignResource {
    @JsonProperty("field")
    private String field;
}
