package com.example.exception;


import com.example.enumentity.ResultCodeEnum;
import com.example.exceptiondemo.ExceptiondemoApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExceptiondemoApplication.class)
public class Test {
    @Autowired
    ExceptionPolicy exceptionPolicy;



    @org.junit.Test
    public void test1(){
        exceptionPolicy.handleException(new Exception(),"policy1", ResultCodeEnum.NEED_RAND_CODE);
    }
}
