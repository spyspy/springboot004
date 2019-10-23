package com.springboot.service;

import com.springboot.entity.LogType;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {
    public String operation();
    public LogType level() default  LogType.INFO;
}
