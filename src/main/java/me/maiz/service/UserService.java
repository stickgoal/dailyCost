package me.maiz.service;


import me.maiz.dal.model.User;
import me.maiz.web.form.RegForm;

/**
 * Created by Lucas on 2017-01-17.
 */
public interface UserService {
    /**
     * 保存
     * @param user
     */
    void save(User user);

    /**
     * 登录
     * @param username
     * @param password
     */
    User login(String username, String password);

    /**
     * 注册
     * @param regForm
     */
    void reg(RegForm regForm);
}
