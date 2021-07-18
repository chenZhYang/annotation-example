package com.aaronchen.annotationexample.aop.aopservice;


import org.springframework.stereotype.Component;

@Component("testAServiceImpl")
public class TestAServiceImpl implements TestService {

    @Override
    public int testAop() {
        System.out.println("进来了A");
        return 0;
    }
}
