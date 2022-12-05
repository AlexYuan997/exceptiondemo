package com.example.handler;

import com.example.handler.IExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class WrapHandler implements IExceptionHandler {
    @Override
    public void execute(Exception e) {
        System.out.println(this.getClass().getName());
    }
}
