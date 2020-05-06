package com.aaronchen.annotationexample.parse;


import com.aaronchen.annotationexample.annotation.MethodInfo;
import com.aaronchen.annotationexample.use.UseAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Aaron chen
 * @Date: 2020/5/7 1:52
 * 解析注解
 */
public class ParseAnnotation {
    static String className = "com.aaronchen.annotationexample.use.UseAnnotation";

    /**
     * 打印出className 类中所有的注解信息，该方法只打印了 Type 类型的注解
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class clazz = Class.forName(className);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation:annotations){
            MethodInfo methodInfo = (MethodInfo) annotation;
            System.out.println("name = "+methodInfo.name()+",id = "+methodInfo.id()+",gid = "+methodInfo.gid());
        }
    }

    /**
     * 打印出UserAnnotation 类中所使用到的方法注解 该方法只打印了 Method 类型的注解
     */
    public static void parseMethodAnnotation(){
        Method[] methods = UseAnnotation.class.getDeclaredMethods();
        for (Method method:methods) {
            /**
             * 判断某个方法是否有指定的注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(MethodInfo.class);
            if(hasAnnotation){
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("method = "+method.getName()+",id = "+
                        methodInfo.id()+",name = "+methodInfo.name()+",gid = "+
                        methodInfo.gid());
            }
        }
    }

    /**
     * 打印出UserAnnotation 类中所使用到的构造方法注解 该方法只打印了 Construct 类型的注解
     */
    public static void parseConstructAnnotation() {
        Constructor<?>[] constructors = UseAnnotation.class.getConstructors();
        for (Constructor construct:constructors) {
            boolean hasAnnotation = construct.isAnnotationPresent(MethodInfo.class);
            if(hasAnnotation){
                MethodInfo methodInfo = (MethodInfo) construct.getAnnotation(MethodInfo.class);
                System.out.println("construct = "+construct.getName()+",id = "+
                        methodInfo.id()+",name = "+methodInfo.name()+",gid = "+
                        methodInfo.gid());
            }
        }
    }

    public static void parseFieldAnnotation() throws ClassNotFoundException {
        Field[] fields = Class.forName(className).getDeclaredFields();
        for (Field field : fields) {
            boolean hasAnnotation = field.isAnnotationPresent(MethodInfo.class);
            if(hasAnnotation){
                MethodInfo methodInfo = field.getAnnotation(MethodInfo.class);
                System.out.println("field = "+field.getName()+",id = "+
                        methodInfo.id()+",name = "+methodInfo.name()+",gid = "+
                        methodInfo.gid());
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        parseMethodAnnotation();
        parseTypeAnnotation();
        parseConstructAnnotation();
        parseFieldAnnotation();
    }
}
