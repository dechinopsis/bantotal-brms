package com.dlya.btbrms.exec.drools;

public class BtResourceString extends BtResourceWrapper{
    private String val;

    public BtResourceString(String val) {
        this.val = val;
    }

    public Object getVal() {
        return this.val;
    }

    @Override
    public void setVal(Object val) {
        this.val = (String) val;
    }

}
