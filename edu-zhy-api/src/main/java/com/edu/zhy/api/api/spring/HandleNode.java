package com.edu.zhy.api.api.spring;

public interface HandleNode<T> {

    String getName();

    void handle(HandleContext<T> context);

    /**
     * 依赖的 node
     */
    default java.util.List<String> requiredNodeName() {
        return new java.util.ArrayList<>();
    }

}
