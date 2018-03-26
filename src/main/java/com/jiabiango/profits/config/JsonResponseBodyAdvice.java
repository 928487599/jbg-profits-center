package com.jiabiango.profits.config;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jiabiango.profits.config.bean.JsonResponseWrapper;
import com.jiabiango.profits.config.bean.LayJsonResponseWrapper;
import com.jiabiango.profits.constant.ApiResultCode;
import com.jiabiango.profits.pager.LayPageResult;

/**
 * 返回结果封装处理
 *
 * @author
 * @date: 2017年4月5日 上午10:26:09
 * @version 1.0
 * @since JDK 1.8
 */
@ControllerAdvice
public class JsonResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return FastJsonHttpMessageConverter.class.isAssignableFrom(converterType)
                || MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public final Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType contentType,
            Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        JsonResponseWrapper jsonResponseWrapper = new JsonResponseWrapper();
        if (body == null) {
            processNullData(returnType, jsonResponseWrapper);
            jsonResponseWrapper.setResCode(ApiResultCode.API_SUCCESS_CODE);
        } else if (body instanceof Principal) {
            return body;
        } else if (body instanceof JsonResponseWrapper) {
            jsonResponseWrapper = (JsonResponseWrapper) body;
            if (jsonResponseWrapper.getData() == null) {
                processNullData(returnType, jsonResponseWrapper);
            }
        } else if(body instanceof LayPageResult) {
            LayJsonResponseWrapper layJsonResponseWrapper = new LayJsonResponseWrapper();
            LayPageResult layPageResult = (LayPageResult)body;
            layJsonResponseWrapper.setCount(layPageResult.getTotal());
            layJsonResponseWrapper.setRows(layPageResult.getList());
            layJsonResponseWrapper.setResCode(ApiResultCode.API_SUCCESS_CODE);
            
            jsonResponseWrapper = layJsonResponseWrapper;
        } else {
            jsonResponseWrapper.setData(body);
            jsonResponseWrapper.setResCode(ApiResultCode.API_SUCCESS_CODE);
        }
        response.getHeaders().set("Content-Type", "application/json;charset=UTF-8");
        return jsonResponseWrapper;
    }

    private void processNullData(MethodParameter returnType, JsonResponseWrapper jsonResponseWrapper) {
        Class<?> returnClass = returnType.getMethod().getReturnType();
        if (returnClass.isArray() || Collection.class.isAssignableFrom(returnClass)) {
            jsonResponseWrapper.setData(Collections.EMPTY_LIST);
        } else {
            jsonResponseWrapper.setData(new Object());
        }
    }
}
