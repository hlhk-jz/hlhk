package com.config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用校验注解来进行一些简单的入参校验
 * public Object data1( @Validated @RequestBody TestPojo testPojo){}
 *
 *  POJO的属性上可以加一下校验注解
 *  @NotBlank(message = "用户ID不能为空")
 *  private String userId;
 *
 * 该注解定义全局异常处理类
 * 等效于 @ControllerAdvice + @ResponseBody
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**可以自定义多个异常按这种方法进行全局捕获 CurentException.class*/
    @ExceptionHandler(value= CurentException.class)
    public Object curentExceptionHandler1(CurentException e){
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode() );
        map.put("message",e.getMessage() );
        return  map;
    }

    /**默认的异常处理  Exception.class*/
    @ExceptionHandler(value= Exception.class)
    public Object exceptionHandler1(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","500");
        map.put("message","系统内部错误");
        return  map;
    }
}
