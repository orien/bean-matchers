package com.google.code.beanmatchers.data;

public class TestBeanNoArgsConstructorThrowsException {

    public TestBeanNoArgsConstructorThrowsException() {
        throw new RuntimeException("No-Args constructor throws exception");
    }
}
