package com.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author lqw
 * @date 2021/10/26-9:01 ����
 */
@Aspect//��ע�������һ������
public class AnnotationPointCut {
    @Before("execution(* com.service.UserServiceImp.*(..))")
    public void before(){

        System.out.println("����ִ��ǰ!");

    }
    @After("execution(* com.service.UserServiceImp.*(..))")
    public void after(){

        System.out.println("����ִ�к�");

    }
    @Around("execution(* com.service.UserServiceImp.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("����ǰ");

//        Signature signature = jp.getSignature();
//        System.out.println("signature"+signature);

        Object proceed = jp.proceed();

        System.out.println("���ƺ�");

    }
}