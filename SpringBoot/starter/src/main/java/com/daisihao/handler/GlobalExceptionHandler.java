package com.daisihao.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    //使用Exception.class指名该方法处理所有的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> handlerException(Exception exception){
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode",500);
        map.put("errorMsg",exception.toString());
        return map;
    }
}
