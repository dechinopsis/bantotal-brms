package com.dlya.btbrms.flow.schema.assign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtAssignEntry {
    @JsonProperty("target")
    private BtAssignResource target;
    @JsonProperty("source")
    private BtAssign source;
}
