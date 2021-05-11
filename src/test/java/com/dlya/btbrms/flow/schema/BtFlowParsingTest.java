package com.dlya.btbrms.flow.schema;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.dlya.btbrms.flow.schema.assign.BtAssignEntry;
import com.dlya.btbrms.flow.schema.assign.BtAssignExpression;
import com.dlya.btbrms.flow.schema.reference.BtReferenceResource;
import com.dlya.btbrms.flow.schema.reference.BtReferenceScalarConst;
import com.dlya.btbrms.flow.schema.step.BtFlowStepAssignment;
import com.dlya.btbrms.flow.schema.step.BtFlowStepStart;
import com.dlya.btbrms.flow.schema.types.*;
import com.dlya.btbrms.flow.schema.resouce.BtFlowResource;
import com.dlya.btbrms.flow.schema.resouce.BtFlowResourceConstant;
import com.dlya.btbrms.flow.schema.resouce.BtFlowResourceVariableScalar;
import com.dlya.btbrms.flow.schema.step.BtFlowStep;
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
                        .hasFieldOrPropertyWithValue("type", BtEFlowStepType.START)
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
                        .hasFieldOrPropertyWithValue("type", BtEFlowStepType.ASSIGNMENT)
                        .extracting("assignments", as(list(BtAssignEntry.class)))
                        .hasSize(3)
                        .satisfies( array -> assertThat(array)
                            .element(0)
                            .asInstanceOf(InstanceOfAssertFactories.type(BtAssignEntry.class))
                            .satisfies( target -> assertThat(target)
                                    .extracting("target", as(type(BtReferenceResource.class)))
                                    .hasFieldOrPropertyWithValue("apiName", "var1")
                            )
                            .satisfies( source -> assertThat(source)
                                    .extracting("source", as(type(BtReferenceScalarConst.class)))
                                    .hasFieldOrPropertyWithValue("type", BtEReferenceType.CONSTANT)
                                    .hasFieldOrPropertyWithValue("value", "10")
                            )
                        )
                        .satisfies( array -> assertThat(array)
                                .element(1)
                                .asInstanceOf(InstanceOfAssertFactories.type(BtAssignEntry.class))
                                .satisfies( target -> assertThat(target)
                                        .extracting("target", as(type(BtReferenceResource.class)))
                                        .hasFieldOrPropertyWithValue("apiName", "var2")
                                )
                                .satisfies( source -> assertThat(source)
                                        .extracting("source", as(type(BtReferenceResource.class)))
                                        .hasFieldOrPropertyWithValue("type", BtEReferenceType.RESOURCE)
                                        .hasFieldOrPropertyWithValue("apiName", "var3")
                                )
                        )
                        .satisfies( array -> assertThat(array)
                                .element(2)
                                .asInstanceOf(InstanceOfAssertFactories.type(BtAssignEntry.class))
                                .satisfies( target -> assertThat(target)
                                        .extracting("target", as(type(BtReferenceResource.class)))
                                        .hasFieldOrPropertyWithValue("apiName", "var4")
                                )
                                .satisfies( source -> assertThat(source)
                                        .extracting("source", as(type(BtAssignExpression.class)))
                                        .hasFieldOrPropertyWithValue("type", BtEReferenceType.EXPRESSION)
                                        .hasFieldOrPropertyWithValue("expression", "LEN(${var5})")
                                )
                        )
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
                .hasFieldOrPropertyWithValue("apiName", "two")
                .hasFieldOrPropertyWithValue("label", "Two")
                .hasFieldOrPropertyWithValue("description", "Two 2")
                .hasFieldOrPropertyWithValue("resourceType", BtEFlowResourceType.CONSTANT)
                .hasFieldOrPropertyWithValue("dataType", BtEScalarPrimitiveType.NUMBER)
                .satisfies( value -> assertThat(value)
                        .extracting("value", as(type(BtReferenceScalarConst.class)))
                        .hasFieldOrPropertyWithValue("type", BtEReferenceType.CONSTANT)
                        .hasFieldOrPropertyWithValue("value", "2")
                );

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