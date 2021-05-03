package com.dlya.btbrms.flow.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtStep {
    @JsonProperty("next")
    private String nextStep;
    @JsonProperty("key")
    private String apiName;
    @JsonProperty("label")
    private String label;
    @JsonProperty("description")
    private String description;
    @JsonProperty("meta")
    private BtMetadataTypeAssignment metadata;
    @JsonProperty("type")
    private BtStepType stepType;
}
