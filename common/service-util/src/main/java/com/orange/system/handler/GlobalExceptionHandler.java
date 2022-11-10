package com.orange.system.handler;

import com.orange.common.result.Result;
import com.orange.common.result.ResultCodeEnum;
import com.orange.system.exception.OrangeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;

/**
 * @author: Li ZhiCheng
 * @create: 2022-10-2022/10/28 14:51
 * @description: 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //捕获异常并处理，最大的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<?> error(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

    //捕获异常并处理，数学异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result<?> error(ArithmeticException e){
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }
    //捕获异常并处理，自定义异常
    @ExceptionHandler(OrangeException.class)
    @ResponseBody
    public Result<?> error(OrangeException e){
        e.printStackTrace();
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }
    /**
     * spring security异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result<?> error(AccessDeniedException e) throws AccessDeniedException {
        return Result.build(null, ResultCodeEnum.PERMISSION);
    }
}
