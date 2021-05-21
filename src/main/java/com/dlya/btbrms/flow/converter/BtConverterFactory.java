package com.dlya.btbrms.flow.converter;

import java.util.Map;

public class BtConverterFactory {
    private static final Map<BtEScriptLanguage, Class> converterByLanguage;

    static {
        converterByLanguage = Map.of(BtEScriptLanguage.DROOLS, BtScriptConverterDrools.class);
    }

    public static BtScriptConverter build(BtConverterBuilder builder) throws Exception {
        return (BtScriptConverter) converterByLanguage
                .get(builder.getLanguage())
                .getDeclaredConstructor(new Class[]{BtConverterBuilder.class})
                .newInstance(builder);
    }
}
