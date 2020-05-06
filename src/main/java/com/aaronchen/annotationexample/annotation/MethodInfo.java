package com.aaronchen.annotationexample.annotation;


import java.lang.annotation.*;

/**
 * 定义注解 MethodInfo
 * 为方便测试：注解目标为类 方法，属性及构造方法
 * 注解中含有三个元素 id ,name和 gid;
 * id 元素 有默认值 0
 * @Author: Aaron chen
 * @Date: 2020/5/7 1:17
 */
@Documented
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,
    ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodInfo {
    String name() default  "annotationTest";
    int id() default 0;
    Class<Long> gid();
}
