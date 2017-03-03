package me.maiz.app.dailycost.service.impl;

import me.maiz.app.dailycost.dal.UserDAO;
import me.maiz.app.dailycost.dal.model.User;
import me.maiz.app.dailycost.enums.DailyCostResultCode;
import me.maiz.app.dailycost.exception.AppException;
import me.maiz.app.dailycost.service.UserService;
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
        userDAO.save(user);
    }

    @Override
    public User login(String username, String password) {
        //TODO 加密密码
        //通过用户名和密码查询用户，查不到 则不存在
        User user = userDAO.findByUsernameAndPassword(username,password);
        if(user==null){
            throw new AppException(DailyCostResultCode.USER_NOT_FOUND_OR_PASSWORD_ERROR);
        }
        return user;
    }
}
