package me.maiz.dal;


import me.maiz.dal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lucas on 2017-01-17.
 */
@Repository("userDAO")
public interface UserDAO extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
