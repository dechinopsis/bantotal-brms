package com.dlya.btbrms.flow.schema;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

@TestWithResources
public class BtFlowParsingTest {
    @Test
    public void testParsing(@GivenJsonResource("/flowJsonSchema/schema1.json") BtFlowDefinition schema) {
        assertThat(schema)
                .isNotNull()
                .extracting("flowSteps", as(map(String.class, BtStep.class)))
                .isNotNull()
                .hasSize(2)
                .hasEntrySatisfying("start", start -> assertThat(start)
                        .isNotNull()
                        .asInstanceOf(InstanceOfAssertFactories.type(BtStep.class))
                        .hasFieldOrPropertyWithValue("apiName", "start")
                        .hasFieldOrPropertyWithValue("nextStep", "assignment1")
                )
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .isNotNull()
                        .asInstanceOf(InstanceOfAssertFactories.type(BtStep.class))
                        .hasFieldOrPropertyWithValue("apiName", "assignment1")
                        .hasFieldOrPropertyWithValue("nextStep", null)
                        .hasFieldOrPropertyWithValue("label", "Assignment 1")
                        .hasFieldOrPropertyWithValue("description", "Assignment Description 1")
                        .hasFieldOrPropertyWithValue("stepType", BtStepType.ASSIGNMENT)
                );
    }
}

