package com.aaronchen.annotationexample.aop.aopservice;

import org.springframework.stereotype.Component;

@Component("testBServiceImpl")
public class TestBServiceImpl implements TestService {


    @Override
    public int testAop() {
        System.out.println("进来了B");
        return 0;
    }
}
