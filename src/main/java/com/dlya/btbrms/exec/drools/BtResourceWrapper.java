package com.dlya.btbrms.exec.drools;

public abstract class BtResourceWrapper {
    private String apiName;
    public abstract Object getVal();
    public abstract void setVal(Object val);
}
