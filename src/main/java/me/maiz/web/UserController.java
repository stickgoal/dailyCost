package me.maiz.web;

import me.maiz.common.Constants;
import me.maiz.dal.model.User;
import me.maiz.service.UserService;
import me.maiz.web.form.LoginForm;
import me.maiz.web.form.RegForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lucas on 2017-01-17.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 渲染注册页面
     * @return
     */
    @RequestMapping(value = "reg", method = RequestMethod.GET)
    public String toReg(HttpServletRequest req,ModelMap mm) {
        if(req.getParameter("ERROR_MSG")!=null)
        mm.addAttribute("msg",req.getParameter("ERROR_MSG"));

        return "reg";
    }

    /**
     * 注册处理
     * @param regForm
     * @param request
     * @return
     */
    @RequestMapping(value = "reg", method = RequestMethod.POST)
    public String reg(RegForm regForm, HttpServletRequest request){
        logger.info("收到注册请求：{}",regForm);
        regForm.validate();

        userService.reg(regForm);
        logger.info("注册处理成功");

        return redirectWithMessage(request,"/","注册成功");
    }

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "/";
    }

    /**
     * 登录处理
     * @param request
     * @param form
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, LoginForm form, ModelMap modelMap) {
        logger.info("收到登录请求：{}",form);

        //验证表单
        form.validate();

        //登录处理
        User user = userService.login(form.getUsername(), form.getPassword());
        request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);

        return "redirect:account";
    }



}
