package com.example.handler;

import java.util.concurrent.ThreadPoolExecutor;

public interface IExceptionHandler<T extends Exception>{

    void execute(T t);
}
