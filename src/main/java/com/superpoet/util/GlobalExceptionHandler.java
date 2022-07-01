package com.superpoet.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理（通过AOP拦截）
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})/*拦截加了这两个注解的类*/
/*通知*/

@ResponseBody//因为这个类最后要返回json数据，这个注解把返回的数据封装成json
@Slf4j//方便输出日志
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)//告诉注解要处理那个异常
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if (ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            return R.error(split[2] + "已存在");
        }

        return R.error("失败了");




    }
}
