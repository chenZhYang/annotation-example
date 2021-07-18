package com.aaronchen.annotationexample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(value = 1)
@Component
public class AopFilter {

    private ProceedingJoinPoint joinPoint;

    @Pointcut(value = "execution(* com.aaronchen.annotationexample.aop.aopservice.TestAServiceImpl.*(..))")
    public void aopAspect(){}

    @Around("aopAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        this.joinPoint = joinPoint;
        String method = joinPoint.getSignature().getName();
        System.out.println("进来了around：" + method);
        return joinPoint.proceed();
    }
}
