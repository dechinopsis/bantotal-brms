package com.dlya.btbrms.exec.drools;

public class BtResourceInteger extends BtResourceWrapper{
    private int val;

    public BtResourceInteger(int val) {
        this.val = val;
    }

    public Object getVal() {
        return this.val;
    }

    @Override
    public void setVal(Object val) {
        this.val = (int) val;
    }
}
