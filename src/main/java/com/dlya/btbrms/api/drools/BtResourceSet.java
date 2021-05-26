package com.dlya.btbrms.api.drools;

import java.util.HashMap;
import java.util.Map;

public class BtResourceSet {
    private BtEResourceSetStatus status;
    private Map<String, BtResource> resource;

    private BtResourceSet(Builder build) {
        this.resource = build.resource;
        this.status = BtEResourceSetStatus.INIT;
    }

    public BtResource get(String apiName) {
        if (resource.containsKey(apiName)) {
            return resource.get(apiName);
        }
        return null;
    }

    public BtEResourceSetStatus getStatus() {
        return status;
    }

    public void setStatus(BtEResourceSetStatus status) {
        this.status = status;
    }

    public Map<String, BtResource> getResource() {
        return this.resource;
    }

    public void setResource(Map<String, BtResource> resource) {
        this.resource = resource;
    }

    public static class Builder {
        private Map<String, BtResource> resource;

        public Builder() {
            resource = new HashMap<String, BtResource>();
        }

        public Builder resource(BtResource res) {
            resource.put(res.getApiName(), res);
            return this;
        }

        public Builder resource(Map<String, BtResource> res) {
            resource.putAll(res);
            return this;
        }

        public BtResourceSet build() {
            return new BtResourceSet(this);
        }
    }
}
