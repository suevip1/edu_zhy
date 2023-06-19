package com.edu.zhy.api.api.spring;

public abstract class HandleContext<T> {

    public abstract T getData();

    public static <T> HandleContext<T> build(T t) {
        return new HandleContext<T>() {
            @Override
            public T getData() {
                return t;
            }
        };
    }


}
