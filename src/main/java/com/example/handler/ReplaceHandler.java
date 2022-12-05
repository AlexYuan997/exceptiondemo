package com.example.handler;

import com.example.handler.IExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class ReplaceHandler implements IExceptionHandler {
    @Override
    public void execute(Exception exception) {

        System.out.println(this.getClass().getName());
    }
}
