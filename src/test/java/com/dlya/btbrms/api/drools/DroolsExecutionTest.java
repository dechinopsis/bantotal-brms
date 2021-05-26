package com.dlya.btbrms.api.drools;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.io.StringReader;

@TestWithResources
public class DroolsExecutionTest {
    @GivenTextResource("/droolsWResources/singleFactBR.drl")
    String singleFactStringRule;

    @Test
    @DisplayName("Resources wrapped in a single fact")
    public void singleFactDrools() {
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();

        Resource inputDrlResource =
                ResourceFactory.newReaderResource(new StringReader(singleFactStringRule));
        kBuilder.add(inputDrlResource, ResourceType.DRL);

        if (kBuilder.hasErrors()) {
            throw new RuntimeException("Unable to compile drl, " + kBuilder.getErrors().toString());
        }

        kBase.addPackages(kBuilder.getKnowledgePackages());

        BtResourceSet resources = new BtResourceSet.Builder()
                .resource(new BtResource("aoimp", Double.valueOf(900)))
                .resource(new BtResource("scmod", Integer.valueOf(108)))
                .resource(new BtResource("sctope", Integer.valueOf(1)))
                .resource(new BtResource("result"))
                .build();

        KieSession kSession = kBase.newKieSession();
        kSession.insert(resources);
        kSession.fireAllRules();
        kSession.dispose();

        Assertions.assertEquals(BtEResourceSetStatus.PROCESSED, resources.getStatus());
        Assertions.assertEquals("MICRO", resources.get("result").getValue());
    }
}
