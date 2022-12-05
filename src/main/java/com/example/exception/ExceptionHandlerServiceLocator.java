package com.example.exception;

import com.example.handler.IExceptionHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExceptionHandlerServiceLocator implements ApplicationContextAware {

    /**
     * 存储 IXxxService接口的所有实现类
     */

    private Map<String, IExceptionHandler> map = new HashMap<>();
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 通过上下文，根据接口类型返回相应的所有实现类bean
        //根据接口类型返回相应的所有bean
        map = applicationContext.getBeansOfType(IExceptionHandler.class);
    }
    /**
     * 获取所有实现集合
     * @return
     */
    public Map<String, IExceptionHandler> getMap() {
        return map;
    }

    /**
     * 获取对应实现类
     * @param key
     * @return
     */
    public IExceptionHandler getService(String key) {
        return map.get(key);
    }


}
