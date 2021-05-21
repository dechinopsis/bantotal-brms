package com.dlya.btbrms.flow.converter;

import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

public class BtConverterBuilder {
    private BtFlowDefinition flowDefinition;
    private String flowSchemaJson;
    private BtEScriptLanguage language;

    public BtConverterBuilder flowSchemaJson(String flowSchemaJson) {
        this.flowSchemaJson = flowSchemaJson;
        return this;
    }

    public BtConverterBuilder language(BtEScriptLanguage language) {
        this.language = language;
        return this;
    }

    public BtFlowDefinition getFlowDefinition() {
        return flowDefinition;
    }

    public BtEScriptLanguage getLanguage() {
        return language;
    }

    public BtScriptConverter build() throws Exception {
        if (StringUtils.isBlank(flowSchemaJson)) {
            throw new IllegalArgumentException("Please provide a JSON flow schema");
        }
        if (language == null) {
            throw new IllegalArgumentException("Please specify a language");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        flowDefinition = objectMapper.readValue(flowSchemaJson, BtFlowDefinition.class);

        return BtConverterFactory.build(this);
    }
}