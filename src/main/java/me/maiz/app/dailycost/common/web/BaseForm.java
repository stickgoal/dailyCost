package me.maiz.app.dailycost.common.web;

import me.maiz.app.dailycost.common.validation.ValidateUtil;

import java.util.Map;

/**
 * Created by Lucas on 2017-03-03.
 */
public abstract class BaseForm {

    /**
     * 执行JSR303校验
     */
    public void validate(){
        ValidateUtil.validate(this);
    }

}
