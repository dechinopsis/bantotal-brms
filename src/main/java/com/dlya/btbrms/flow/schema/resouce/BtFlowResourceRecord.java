package com.dlya.btbrms.flow.schema.resouce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtFlowResourceRecord extends BtFlowResource {
    @JsonProperty("table")
    private String table;
    @JsonProperty("isCollection")
    private Boolean collection;
}
