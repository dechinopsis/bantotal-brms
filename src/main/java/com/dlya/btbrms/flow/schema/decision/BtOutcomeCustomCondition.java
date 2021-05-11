package com.dlya.btbrms.flow.schema.decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtOutcomeCustomCondition extends BtOutcomeWResources{
    @JsonProperty("customCondition")
    private String customCondition;
}
