/*
package com.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectConfig {
    @Pointcut("execution(* com.controller.*.*(..))")
    public void show(){}

    @Around(value = "show()")
    public Object test(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        Object obj = args[0];
        log.info("======= "+args);
        return "";
    }

}
*/
