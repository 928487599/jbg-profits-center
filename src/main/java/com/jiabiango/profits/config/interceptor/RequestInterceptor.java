package com.jiabiango.profits.config.interceptor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jiabiango.profits.util.JsonUtil;

@Component
@Aspect
public class RequestInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
	
	@Value("${spring.profiles.active}")
	private String active;
	
	/**
	 * 判断传入参数是否合法
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	@Around(value="execution(* com.jiabiango.promotion.*.controller.*.*(..))")
	public Object process(ProceedingJoinPoint point) throws Throwable{
	    long start = System.currentTimeMillis();
	    Method method =  ((MethodSignature)point.getSignature()).getMethod();
	    List<Object> logArgs = new ArrayList<>();
	    Object returnValue = null;
	    try {
    		Object[] args = point.getArgs();
    		for(int i = 0; i < args.length; i++) {
                if(args[i] instanceof HttpServletRequest) {
                    continue;
                } else if(args[i] instanceof HttpServletResponse) {
                    continue;
                } else if(args[i] instanceof HttpSession) {
                    continue;
                }
                logArgs.add(args[i]);
                
            }
    		returnValue = point.proceed(args);
    		return returnValue;
		} finally {
		    if("dev".equals(active)) {
		        logger.info("调用接口{},参数:{},返回:{},耗时:{}ms", method.getDeclaringClass().getName() + "." + method.getName(), JsonUtil.toJson(logArgs), JsonUtil.toJson(returnValue), System.currentTimeMillis() - start);
            } else {
                logger.info("调用接口{},参数:{},返回:{},耗时:{}ms", method.getDeclaringClass().getName() + "." + method.getName(), JsonUtil.toJson(logArgs), "忽略", System.currentTimeMillis() - start);
            }
		}
	}
}
