package com.mg.dev.postgres.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
public class LogTrace {

    @Pointcut("@annotation(com.mg.dev.postgres.aop.annotation.LogTrace)")
    public void logTrace() {};

    @Around("logTrace()")
    public void doTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        StopWatch watch = new StopWatch();
        watch.start("doTrace");

        log.info("[Trace] {}, args={}", joinPoint.getSignature(), args);
        joinPoint.proceed();
        watch.stop();

        log.info("proceed Time={}ms", watch.getTotalTimeMillis());

    }

}
