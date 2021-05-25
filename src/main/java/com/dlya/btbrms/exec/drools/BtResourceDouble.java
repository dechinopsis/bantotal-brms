package com.dlya.btbrms.exec.drools;

public class BtResourceDouble extends BtResourceWrapper {
    private double val;

    public BtResourceDouble(double val) {
        this.val = val;
    }

    public Object getVal() {
        return this.val;
    }

    @Override
    public void setVal(Object val) {
        this.val = (double) val;
    }

}
