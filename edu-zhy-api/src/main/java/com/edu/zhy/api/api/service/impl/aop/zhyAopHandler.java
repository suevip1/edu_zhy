package com.edu.zhy.api.api.service.impl.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;

@Slf4j
@Aspect
public class zhyAopHandler {


    @Pointcut("@annotation(com.edu.zhy.api.api.service.impl.aop.ZhyAopLog)")
    public void zhyAopLog() {
    }


    @Before(value = "zhyAopLog()")
    public void before(JoinPoint point){
        String name = point.getSignature().getName();
        System.err.println("before"+"//"+"name"+name);
        Object[] args = point.getArgs();
        System.err.println("before"+"//"+"args"+args);
        SourceLocation sourceLocation = point.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.err.println("fileName"+"//"+"fileName"+fileName);

    }


    @After(value = "zhyAopLog()")
    public void after(JoinPoint point){
        String name = point.getSignature().getName();
        System.err.println("after"+"//"+"name"+name);
        Object[] args = point.getArgs();
        System.err.println("after"+"//"+"args"+args);
        SourceLocation sourceLocation = point.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.err.println("after"+"//"+"fileName"+fileName);

    }

    @AfterReturning
    public void afterReturning(JoinPoint point){

        String name = point.getSignature().getName();
        System.err.println("afterReturning"+"//"+"name"+name);
        Object[] args = point.getArgs();
        System.err.println("afterReturning"+"//"+"args"+args);
        SourceLocation sourceLocation = point.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.err.println("afterReturning"+"//"+"fileName"+fileName);
    }

    @Around(value = "zhyAopLog()")
    public void around(JoinPoint point){
        String name = point.getSignature().getName();
        System.err.println("around"+"//"+"name"+name);
        Object[] args = point.getArgs();
        System.err.println("around"+"//"+"args"+args);
        SourceLocation sourceLocation = point.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.err.println("around"+"//"+"fileName"+fileName);


    }


    @AfterThrowing
    public void afterThrowing(JoinPoint point){
        String name = point.getSignature().getName();
        System.err.println("afterThrowing"+"//"+"name"+name);
        Object[] args = point.getArgs();
        System.err.println("afterThrowing"+"//"+"args"+args);
        SourceLocation sourceLocation = point.getSourceLocation();
        String fileName = sourceLocation.getFileName();
        System.err.println("afterThrowing"+"//"+"fileName"+fileName);


    }




}
