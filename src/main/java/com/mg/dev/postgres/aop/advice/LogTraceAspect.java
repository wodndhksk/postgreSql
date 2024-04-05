package com.mg.dev.postgres.aop.advice;

import com.mg.dev.postgres.aop.annotation.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
public class LogTraceAspect {

    @Around("@annotation(annotation)")
    public void doTrace(ProceedingJoinPoint joinPoint, LogTrace annotation) throws Throwable {
        Object[] args = joinPoint.getArgs();

        StopWatch watch = new StopWatch();
        watch.start("doTrace");

        log.info("[Trace] {}, args={}", joinPoint.getSignature(), args);
        joinPoint.proceed();
        watch.stop();

        log.info("proceed Time={}ms", watch.getTotalTimeMillis());

    }

}
