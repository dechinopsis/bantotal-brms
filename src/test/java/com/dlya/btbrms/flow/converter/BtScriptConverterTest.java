package com.dlya.btbrms.flow.converter;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.dlya.btbrms.flow.schema.BtFlowDefinition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@TestWithResources
public class BtScriptConverterTest {
    @GivenTextResource("/flowJsonSchema/schema_sample_no_parameters.json")
    String schemaSampleText;

    @Test
    @DisplayName("Convert JSON to script")
    public void convertJSONToScript() throws IOException {
        BtScriptConverter converter = new BtScriptConverter.Builder()
                .flowSchemaJson(schemaSampleText)
                .language(BtScriptLanguage.JAVASCRIPT)
                .build();

        assertThat(converter).isNotNull();
    }
}
