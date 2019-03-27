package com.daisihao.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP切面
 * 1、拦截所有Dao层方法
 * 2、判断方法名称是否为存在于 QUERY_PREFIX 中定义的前缀
 * 3、如果存在:则调用ContextHolder中的useSlaveDataSource方法,使用从数据库
 * 4、如果不存在:使用默认数据库
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    //设置需要判断的方法名前缀集合
    private final String[] QUERY_PREFIX = {"get", "select"};

    //判断切入点的方法名是否在设定的前缀中
    private Boolean isQueryMethod(String methodName) {
        for (String prefix : QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    @Pointcut("execution( * com.daisihao.mapper.*.*(..))")
    public void daoAspect() {
    }

    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
        if (isQueryMethod) {
            DynamicDataSourceContextHolder.useSlaveDataSource();
        }
    }

    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }


}
