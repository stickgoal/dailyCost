package me.maiz.app.dailycost.web;

import me.maiz.app.dailycost.common.Constants;
import me.maiz.app.dailycost.common.validation.DCValidatorFactory;
import me.maiz.app.dailycost.dal.model.User;
import me.maiz.app.dailycost.enums.DailyCostResultCode;
import me.maiz.app.dailycost.exception.AppException;
import me.maiz.app.dailycost.service.UserService;
import me.maiz.app.dailycost.web.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lucas on 2017-01-17.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String toReg() {
        return "reg";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, LoginForm form,ModelMap modelMap) {
        try {

            //验证表单
            form.validate();

            //登录处理
            User user = userService.login(form.getUsername(), form.getPassword());
            request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);

        }catch(AppException e){
            logger.info("登录业务异常：{}，{}",e.getResultCode(),e.getMessage());
            if(e.getResultCode()== DailyCostResultCode.INVALID_ARGUMENT){
                modelMap.put(Constants.MSG_KEY,"参数不合法（"+e.getMessage());
            }

            if(e.getResultCode()== DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR){
                modelMap.put(Constants.MSG_KEY,DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR.getMessage());
            }
            return "forward:/index.jsp";
        }

        return "redirect:account";
    }

    @RequestMapping("account")
    public String toAccount(){
        return "account";
    }

}
