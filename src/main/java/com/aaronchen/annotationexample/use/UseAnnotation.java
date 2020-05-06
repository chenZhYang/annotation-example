package com.aaronchen.annotationexample.use;

import com.aaronchen.annotationexample.annotation.MethodInfo;

/**
 * @Author: Aaron chen
 * @Date: 2020/5/7 1:24
 * 使用注解
 */
@MethodInfo(name = "type",gid = Long.class)//类成员注解
public class UseAnnotation {

    /**
     * 类成员注解
     */
    @MethodInfo(name = "param",id = 1,gid = Long.class)
    private Integer age;

    /**
     * 类构造方法注解
     */
    @MethodInfo(name = "construct",id = 2,gid = Long.class)
    public UseAnnotation(){
    }

    /**
     * 类方法注解
     */
    @MethodInfo(name = "public method",id = 3,gid = Long.class)
    public void a(){
        System.out.println("public method");
    }

    @MethodInfo(name = "protected method",id = 4,gid = Long.class)
    protected void b(){
        System.out.println("protected method");
    }

    @MethodInfo(name = "private method",id = 5,gid = Long.class)
    private void c(){
        System.out.println("private method");
    }

    public void b(Integer a){

    }
}
