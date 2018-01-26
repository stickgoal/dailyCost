package me.maiz.web;


import me.maiz.common.Constants;
import me.maiz.common.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lucas on 2017-02-20.
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected String redirectWithMessage(HttpServletRequest request, String uri, String message){
        return WebUtil.redirectWithMessage(Constants.MSG_KEY,request,uri,message);
    }

    protected String redirectWithErrorMessage(HttpServletRequest request, String uri, String message){
        return WebUtil.redirectWithMessage(Constants.ERROR_MSG_KEY,request,uri,message);
    }
}
