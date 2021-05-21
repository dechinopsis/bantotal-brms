package com.dlya.btbrms.flow.converter;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@TestWithResources
public class BtScriptConverterTest {
    @GivenTextResource("/flowJsonSchema/schema_sample_no_parameters.json")
    String schemaSampleText;

    @Test
    @DisplayName("Convert JSON to .drl")
    public void convertJSONToDrl() throws Exception {
        BtScriptConverter converter = new BtConverterBuilder()
                .flowSchemaJson(schemaSampleText)
                .language(BtEScriptLanguage.DROOLS)
                .build();

        String script = converter.generate();
        assertThat(script).isNotNull();
    }
}
