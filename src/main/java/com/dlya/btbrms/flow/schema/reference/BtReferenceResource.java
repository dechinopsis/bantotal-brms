package com.dlya.btbrms.flow.schema.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BtReferenceResource extends BtReferenceValue {
    @JsonProperty("apiName")
    private String apiName;
}
