package com.springboot.ecommerce;

import com.springboot.ecommerce.exception.ApiDisabledException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DisabledApiAspect {

    @Pointcut("@annotation(com.springboot.ecommerce.DisabledApi)")
    public void disabledApi() {}

    @Around("disabledApi()")
    public Object around(ProceedingJoinPoint pjp) {
        throw new ApiDisabledException("Api Disabled");
    }
}
