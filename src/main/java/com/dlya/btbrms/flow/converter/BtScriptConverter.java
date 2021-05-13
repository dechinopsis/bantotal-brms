package com.dlya.btbrms.flow.converter;

import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class BtScriptConverter {
    private BtFlowDefinition flow;
    private BtScriptLanguage language;
    private BtScriptConverter(Builder builder){
        this.flow = builder.flow;
        this.language = builder.language;
    }

    public static class Builder {
        private BtFlowDefinition flow;
        private String flowSchemaJson;
        private BtScriptLanguage language;

        public Builder(){

        }

        public Builder flowSchemaJson(String flowSchemaJson) {
            this.flowSchemaJson = flowSchemaJson;
            return this;
        }

        public Builder language(BtScriptLanguage language) {
            this.language = language;
            return this;
        }

        public BtScriptConverter build() throws IOException {
            if(StringUtils.isBlank(flowSchemaJson)){
                throw new IllegalArgumentException("Please provide a JSON flow schema");
            }
            if(language == null){
                throw new IllegalArgumentException("Please specify a language");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            flow = objectMapper.readValue(flowSchemaJson, BtFlowDefinition.class);

            return new BtScriptConverter(this);
        }

    }
}
