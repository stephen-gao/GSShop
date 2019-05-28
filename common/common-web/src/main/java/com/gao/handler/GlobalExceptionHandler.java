package com.gao.handler;

import com.gao.base.result.Result;
import com.gao.base.result.ResultEnum;
import com.gao.base.result.ResultFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author gs
 * @Date created time 2019/4/28 15:38
 * @Description
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LogManager.getLogger(this.getClass());

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result exceptionHandler(RuntimeException e){
        //捕捉异常打印控制台
        logger.error(e);
        logger.error(e);
        e.printStackTrace();
        return ResultFactory.getDefaultResult(ResultEnum.INTERNAL_SERVER_ERROR);
    }
}
