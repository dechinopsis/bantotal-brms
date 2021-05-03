package com.dlya.btbrms.flow.schema;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.*;

@TestWithResources
public class BtFlowParsingTest {
    @GivenJsonResource("/flowJsonSchema/schema1.json")
    BtFlowDefinition schema;

    @Test
    @DisplayName("JSON flow schema, start")
    public void testStartStep() {
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
                );
    }

    @Test
    @DisplayName("JSON flow schema, assignment")
    public void testAssignmentStep() {
        assertThat(schema)
                .isNotNull()
                .extracting("flowSteps", as(map(String.class, BtStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .isNotNull()
                        .asInstanceOf(InstanceOfAssertFactories.type(BtStep.class))
                        .hasFieldOrPropertyWithValue("apiName", "assignment1")
                        .hasFieldOrPropertyWithValue("nextStep", null)
                        .hasFieldOrPropertyWithValue("label", "Assignment 1")
                        .extracting("metadata", as(type(BtAssignmentMetadataType.class)))
                        .hasFieldOrPropertyWithValue("stepType", BtEStepType.ASSIGNMENT)
                        .extracting("assignmentsList", as(list(BtAssignmentEntry.class)))
                        .hasSize(3)
                        .extracting(BtAssignmentEntry::getVariableApiName)
                        .containsExactly("var1", "var2", "var4")
                );

        assertThat(schema)
                .extracting("flowSteps", as(map(String.class, BtStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .extracting("metadata", as(type(BtAssignmentMetadataType.class)))
                        .hasFieldOrPropertyWithValue("stepType", BtEStepType.ASSIGNMENT)
                        .extracting("assignmentsList", as(list(BtAssignmentEntry.class)))
                        .extracting(BtAssignmentEntry::getAssignmentType)
                        .containsExactly(
                                BtEAssignmentEntryType.CONSTANT,
                                BtEAssignmentEntryType.VARIABLE,
                                BtEAssignmentEntryType.EXPRESSION
                        )
                );
        assertThat(schema)
                .extracting("flowSteps", as(map(String.class, BtStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .extracting("metadata", as(type(BtAssignmentMetadataType.class)))
                        .hasFieldOrPropertyWithValue("stepType", BtEStepType.ASSIGNMENT)
                        .extracting("assignmentsList", as(list(BtAssignmentEntry.class)))
                        .extracting(BtAssignmentEntry::getValue)
                        .containsExactly("10", "var3", "LEN(${var5})")
                );
    }
}