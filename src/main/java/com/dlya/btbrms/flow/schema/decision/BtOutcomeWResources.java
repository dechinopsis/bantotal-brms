package com.dlya.btbrms.flow.schema.decision;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BtOutcomeWResources extends BtOutcome {
    @JsonProperty("entries")
    private List<BtOutcomeWResourcesEntry> entries;
}
