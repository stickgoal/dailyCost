package me.maiz.service.impl;

import me.maiz.common.SimpleDigestUtil;
import me.maiz.common.enums.DailyCostResultCode;
import me.maiz.common.exceptions.AppException;
import me.maiz.dal.UserDAO;
import me.maiz.dal.model.User;
import me.maiz.service.UserService;
import me.maiz.web.form.RegForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lucas on 2017-01-17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void save(User user) {

        user.setPassword(SimpleDigestUtil.encryptSHA(user.getPassword()));

        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        //通过用户名和密码查询用户，查不到 则不存在
        User user = userDAO.findByUsernameAndPassword(username, SimpleDigestUtil.encryptSHA(password));
        if(user==null){
            throw new AppException(DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public void reg(RegForm regForm) {
        User user = new User();
        BeanUtils.copyProperties(regForm,user);
        user.setPassword(SimpleDigestUtil.encryptSHA(user.getPassword()));
        userDAO.save(user);
    }
}
