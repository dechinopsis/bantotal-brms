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
    @GivenJsonResource("/flowJsonSchema/schema_steps.json")
    BtFlowDefinition schemaSteps;

    @GivenJsonResource("/flowJsonSchema/schema_resources.json")
    BtFlowDefinition schemaResources;

    @Test
    @DisplayName("JSON flow schema, start")
    public void testStartStep() {
        assertThat(schemaSteps)
                .isNotNull()
                .extracting("flowSteps", as(map(String.class, BtFlowStep.class)))
                .isNotNull()
                .hasSize(2)
                .hasEntrySatisfying("start", start -> assertThat(start)
                        .isNotNull()
                        .asInstanceOf(InstanceOfAssertFactories.type(BtFlowStepStart.class))
                        .hasFieldOrPropertyWithValue("apiName", "start")
                        .hasFieldOrPropertyWithValue("startAt", "assignment1")
                        .hasFieldOrPropertyWithValue("type", BtEStepType.START)
                );
    }

    @Test
    @DisplayName("JSON flow schema, assignment")
    public void testAssignmentStep() {
        assertThat(schemaSteps)
                .isNotNull()
                .extracting("flowSteps", as(map(String.class, BtFlowStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .isNotNull()
                        .asInstanceOf(InstanceOfAssertFactories.type(BtFlowStepAssignment.class))
                        .hasFieldOrPropertyWithValue("apiName", "assignment1")
                        .hasFieldOrPropertyWithValue("label", "Assignment 1")
                        .hasFieldOrPropertyWithValue("next", "gxCall1")
                        .hasFieldOrPropertyWithValue("description", "Assignment Description 1")
                        .hasFieldOrPropertyWithValue("type", BtEStepType.ASSIGNMENT)
                        .extracting("assignments", as(list(BtAssignmentEntry.class)))
                        .hasSize(3)
                        .extracting(BtAssignmentEntry::getVariableApiName)
                        .containsExactly("var1", "var2", "var4")
                );

        assertThat(schemaSteps)
                .extracting("flowSteps", as(map(String.class, BtFlowStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .extracting("assignments", as(list(BtAssignmentEntry.class)))
                        .extracting(BtAssignmentEntry::getAssignmentType)
                        .containsExactly(
                                BtEAssignmentEntryType.CONSTANT,
                                BtEAssignmentEntryType.VARIABLE,
                                BtEAssignmentEntryType.EXPRESSION
                        )
                );
        assertThat(schemaSteps)
                .extracting("flowSteps", as(map(String.class, BtFlowStep.class)))
                .hasEntrySatisfying("assignment1", start -> assertThat(start)
                        .extracting("assignments", as(list(BtAssignmentEntry.class)))
                        .extracting(BtAssignmentEntry::getValue)
                        .containsExactly("10", "var3", "LEN(${var5})")
                );
    }

    @Test
    @DisplayName("JSON resources")
    public void testResources() {
        assertThat(schemaResources)
                .isNotNull()
                .extracting("flowResources", as(list(BtFlowResource.class)))
                .isNotNull()
                .hasSize(2)
                .element(0)
                .asInstanceOf(InstanceOfAssertFactories.type(BtFlowResourceConstant.class))
                .hasFieldOrPropertyWithValue("apiName", "constant1")
                .hasFieldOrPropertyWithValue("label", "Constant")
                .hasFieldOrPropertyWithValue("description", "Description of constant")
                .hasFieldOrPropertyWithValue("resourceType", BtEFlowResourceType.CONSTANT)
                .hasFieldOrPropertyWithValue("dataType", BtEScalarPrimitiveType.NUMBER);

        assertThat(schemaResources)
                .extracting("flowResources", as(list(BtFlowResource.class)))
                .element(1)
                .asInstanceOf(InstanceOfAssertFactories.type(BtFlowResourceVariableScalar.class))
                .hasFieldOrPropertyWithValue("apiName", "var1")
                .hasFieldOrPropertyWithValue("label", "variable1")
                .hasFieldOrPropertyWithValue("description", "Description of variable")
                .hasFieldOrPropertyWithValue("resourceType", BtEFlowResourceType.SCALAR_VARIABLE)
                .hasFieldOrPropertyWithValue("dataType", BtEScalarPrimitiveType.TEXT)
                .hasFieldOrPropertyWithValue("in", false)
                .hasFieldOrPropertyWithValue("out", true)
                .hasFieldOrPropertyWithValue("hasDefault", false)
        ;
    }
}