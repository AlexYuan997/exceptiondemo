package com.example.exception;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常控制
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 业务异常处理
     */
    @ResponseBody
    public JSONObject errorHandler(HttpServletRequest request, BaseException exception, HttpServletResponse response) {
        System.out.println("业务异常======================================================");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", exception.getCode().toString());
        jsonObject.put("message", exception.getMessage());
//        jsonObject.put("getLocalizedMessage", exception.getLocalizedMessage());
//        jsonObject.put("HttpStatus", exception.getCause().toString());

        return jsonObject;
    }



}