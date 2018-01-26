package me.maiz.common.web;

import com.google.common.base.MoreObjects;
import me.maiz.common.validation.ValidateUtil;

/**
 * Created by Lucas on 2017-03-03.
 */
public abstract class BaseForm {

    /**
     * 执行JSR303校验
     */
    public void validate(){
        ValidateUtil.validate(this);
        validateMore();
    }

    /**
     * 更多校验，默认不需要，子类可以选择覆盖以实现更多校验
     */
    protected void validateMore() {
        //用作继承后覆盖
    }


    public String toString(){
        return MoreObjects.toStringHelper(this).toString();
    }
}
