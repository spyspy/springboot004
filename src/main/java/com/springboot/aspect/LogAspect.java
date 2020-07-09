package com.springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.springboot.controller.*.*(..))")
    public void controllerLog() {
        System.out.println("AOP: controllerLog()");
    }

    @Before(value = "controllerLog()")
    public void doControllerBefore(JoinPoint point) {
        System.out.println("AOP: doControllerBefore: Before!!!");
        Signature signature = point.getSignature();

//        log.debug("call controller: {}, method: {}, args: {}", signature.getDeclaringTypeName(), signature.getName(), point.getArgs());

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

    }

    @AfterReturning(value = "controllerLog()", returning = "args")
    public void doControllerAfterReturning(JoinPoint point, Object args) {
        System.out.println("AOP: doControllerAfterReturning: After");

        Signature signature = point.getSignature();

//        log.debug("return controller: {}, method: {}, args: {}", signature.getDeclaringTypeName(), signature.getName(), args);
    }

//    @Around(value="WOW")
//    public void wow(){
//
//    }

}
