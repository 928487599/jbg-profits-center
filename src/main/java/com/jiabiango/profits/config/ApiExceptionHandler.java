package com.jiabiango.profits.config;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.jiabiango.profits.config.bean.JsonResponseWrapper;
import com.jiabiango.profits.constant.ApiResultCode;
import com.jiabiango.profits.exception.ApiException;

@Component
public class ApiExceptionHandler implements HandlerExceptionResolver{
	public static Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@SuppressWarnings("unchecked")
    @Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) {
	    JsonResponseWrapper jsonWrapper = new JsonResponseWrapper();
	    if(ex instanceof ApiException) {
	        jsonWrapper.setResCode(((ApiException) ex).getErroCode());
	        jsonWrapper.setResInfo(ex.getMessage());
	    } else {
	        logger.error("系统异常, handler={}", object, ex);
	        jsonWrapper.setResCode(ApiResultCode.SYSTEM_ERR_CODE);
            jsonWrapper.setResInfo(ApiResultCode.SYSTEM_ERR_MSG);
	    }
	    
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		String json;
        try {
            json = view.getObjectMapper().writeValueAsString(jsonWrapper);
            view.setAttributesMap(view.getObjectMapper().readValue(json, HashMap.class));
        } catch (Exception e) {
            logger.error("json序列化错误");
        }
	    return new ModelAndView(view);
	}
}
