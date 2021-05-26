package com.dlya.btbrms.api.drools;

public class BtResource<T> {
    private String apiName;
    private T value;

    public BtResource(String apiName, T value) {
        this.apiName = apiName;
        this.value = value;
    }

    public BtResource(String apiName) {
        this.apiName = apiName;
        this.value = null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public String getApiName() {
        return this.apiName;
    }
}
