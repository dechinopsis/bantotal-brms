package com.dlya.btbrms.flow.schema.decision;

public enum BtOperator {
    //Generic
    EQUALS,
    DOES_NOT_EQUALS,

    //Numeric, date and datetime
    GREATER_THAN,
    LESS_THAN,
    GREATER_OR_EQUAL_THAN,
    LESS_OR_EQUAL_THAN,

    //Text
    CONTAINS,
    STARTS_WITH,
    ENDS_WITH,
    IS_BLANK,

    //Boolean
    IS_TRUTHY,
    IS_FALSY,

    //ARRAY
    IS_EMPTY
}
