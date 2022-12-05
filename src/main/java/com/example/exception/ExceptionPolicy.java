package com.example.exception;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.example.entity.ExceptionResult;
import com.example.enumentity.ResultCodeInterface;
import com.example.handler.IExceptionHandler;
import com.sun.deploy.util.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class ExceptionPolicy implements ApplicationContextAware {

    @Autowired
    ApplicationContext applicationContext;

    private IExceptionHandler iExceptionHandler;

    @Value("ex.isthrow")
    private  String  isThrow;

    @Autowired
    ExceptionHandlerServiceLocator exceptionHandlerServiceLocator;


    @Autowired
    Environment environment;

    public ExceptionPolicy() {


    }

    public ExceptionResult handleException(Exception ex,
                                           String handle,
                                           ResultCodeInterface resultCodeInterface){
        ExceptionResult result=new ExceptionResult();
        result.setEx(new BaseException(resultCodeInterface));
        result.setIsThrow(Boolean.valueOf(this.isThrow));
        String property = environment.getProperty("ex." + handle);
        if (!StrUtil.isBlank(property)){
            Map<String, IExceptionHandler> allMap = applicationContext.getBeansOfType(IExceptionHandler.class);
            allMap.forEach((s,v)->{
                //TODO 对比配置文件中包含那些策略，根据策略类名获取策略示例，按照配置的策略执行
                IExceptionHandler bean = (IExceptionHandler) applicationContext.getBean("策略类名");
                //调用策略执行
                bean.execute(ex);
            });
        }
        return result;
    }


}
