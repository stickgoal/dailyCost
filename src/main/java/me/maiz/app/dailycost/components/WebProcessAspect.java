package me.maiz.app.dailycost.components;

import me.maiz.app.dailycost.common.Constants;
import me.maiz.app.dailycost.enums.DailyCostResultCode;
import me.maiz.app.dailycost.exception.AppException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.Arrays;

/**
 * 拦截处理所有controller的公共方法，提供通用处理
 * Created by Lucas on 2017-03-08.
 */
@Component
//将此类搞成切面
@Aspect
//切面的顺序
@Order(1)
public class WebProcessAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebProcessAspect.class);

    //指定切入点为所有web包下的controller的public方法
    @Pointcut("execution(public * me.maiz.app.dailycost.web.*(..))")
    public void aroundControllerProcessAspect(){}

    @Around("aroundControllerProcessAspect()")
    public Object aroundAdvice(ProceedingJoinPoint pjd){
        Object result = null;
        Object[] args = pjd.getArgs();
        ModelMap modelMap = getModel(args);
        logger.info("请求参数：{}", Arrays.toString(args));
        try{

            result =   pjd.proceed();

        }catch(AppException e){
            logger.info("登录业务异常：{}，{}",e.getResultCode(),e.getMessage());
            if(e.getResultCode()== DailyCostResultCode.INVALID_ARGUMENT){
                modelMap.put(Constants.MSG_KEY,"参数不合法（"+e.getMessage());
            }

            if(e.getResultCode()== DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR){
                modelMap.put(Constants.MSG_KEY,DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR.getMessage());
            }
            return "error";
        } catch (Throwable throwable) {
            logger.error("执行出现系统错误",throwable);
            return "error";
        }
        logger.info("返回值：{}",result);

        return result;
    }

    private ModelMap getModel(Object[] args) {
        for(Object o : args){
            if( o instanceof ModelMap){
                return (ModelMap) o;
            }
        }
        //不太靠谱的做法
        return new ModelMap();
    }

}
