package com.dlya.btbrms.exec.drools;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@TestWithResources
public class DroolsExecutionTest {
    @GivenTextResource("/droolsWResources/singleFactBR.drl")
    String singleFactStringRule;

    @Test
    @DisplayName("Resources wrapped in a single fact")
    public void singleFactDrools() throws Exception {
        String ruleApiName = "_singleFactBR";

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Collection<KiePackage> pkgs;
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        KieSession ksession;

        BtResourceMap resources = new BtResourceMap(new HashMap<>(Map.of(
                "aoimp", new BtResourceDouble(900),
                "scmod", new BtResourceInteger(108),
                "sctope", new BtResourceInteger(1),
                "result", new BtResourceString("")
        )));

        Resource myResource = ResourceFactory.newReaderResource(new StringReader(singleFactStringRule));
        kbuilder.add(myResource, ResourceType.DRL);

        if (kbuilder.hasErrors()) {
            throw new RuntimeException("Unable to compile drl, " + kbuilder.getErrors().toString());
        }

        pkgs = kbuilder.getKnowledgePackages();

        kbase.addPackages(pkgs);

        ksession = kbase.newKieSession();
        ksession.insert(resources);
        ksession.fireAllRules();
        ksession.dispose();

        Assertions.assertEquals("MICRO", resources.getRes().get("result").getVal());
    }
}
