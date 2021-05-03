package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BtStepType {
    @JsonProperty("start")
    START,
    @JsonProperty("gxCall")
    GX_PROCEDURE,
    @JsonProperty("dbQuery")
    DB_QUERY,
    @JsonProperty("assignment")
    ASSIGNMENT,
    @JsonProperty("condition")
    CONDITION,
    @JsonProperty("flow")
    SUB_FLOW,
    @JsonProperty("dbInsert")
    DB_INSERT,
    @JsonProperty("dbUpdate")
    DB_UPDATE,
    @JsonProperty("dbDelete")
    DB_DELETE
}
