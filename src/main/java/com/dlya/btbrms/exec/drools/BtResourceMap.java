package com.dlya.btbrms.exec.drools;

import java.util.Map;

public class BtResourceMap {
    private Map<String, BtResourceWrapper> res;

    public BtResourceMap(Map<String, BtResourceWrapper> res) {
        this.res = res;
    }

    public Map<String, BtResourceWrapper> getRes() {
        return this.res;
    }

    public void setRes(Map<String, BtResourceWrapper> res) {
        this.res = res;
    }
}
