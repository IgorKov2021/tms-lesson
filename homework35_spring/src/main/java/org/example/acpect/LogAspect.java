package org.example.acpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution( * org.example.impl.ServiceStartsImpl.startRacing())")
    public void pointcut() {}

    @Around("pointcut()")
    public Object logProcess(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            long start = System.nanoTime();
            Object proceed = proceedingJoinPoint.proceed();
            long end = System.nanoTime();
            String name = proceedingJoinPoint.getSignature().getName();
            System.out.println("Время работы метода " + name + " :" + (end - start) + " nanoseconds");
            return proceed;

    }
}
