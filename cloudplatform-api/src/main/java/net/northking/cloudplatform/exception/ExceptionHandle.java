package net.northking.cloudplatform.exception;


import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Title: 异常处理类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/14
 * @UpdateUser:
 * @Version:0.1
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler
    @ResponseBody
    public ResultInfo handle(Exception e){
        if(e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            logger.error("["+ globalException.getMessage() + "]:", e);
            return new ResultInfo(globalException.getCode(), globalException.getMessage());
        }else if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException methodlException = (MethodArgumentNotValidException) e;
            String message = methodlException.getMessage();
            return new ResultInfo(ResultCode.INVALID_PARAM.code(),methodlException.getLocalizedMessage().substring(message.lastIndexOf("[")+1).replaceAll("]","").trim());

        }else if(e instanceof AccessDeniedException){
            logger.error("["+ ResultCode.ACCESSDENIED.msg() + "]:", e);
            return new ResultInfo(ResultCode.ACCESSDENIED);
        } else {
            logger.error("["+ ResultCode.EXCEPTION.msg() + "]:", e);
            return new ResultInfo(ResultCode.EXCEPTION);
        }
    }
}
