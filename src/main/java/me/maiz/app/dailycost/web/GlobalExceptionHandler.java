package me.maiz.app.dailycost.web;

import me.maiz.app.dailycost.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lucas on 2017-02-21.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public String logException(Exception e, HttpServletRequest request){
        logger.error("系统异常被捕获",e);
        request.setAttribute(Constants.MSG_KEY,e.getMessage());
        return "error";
    }

}
