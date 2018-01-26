package me.maiz.web.form;

import me.maiz.common.web.BaseForm;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Lucas on 2017-02-20.
 */
public class LoginForm  extends BaseForm {

    @NotBlank
    @Length(max = 256,min=3)
    private String username;

    @NotBlank
    @Length(max = 256,min=3)
    private String password;

    private String remember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='******', remember='" + remember + '\'' +
                '}';
    }
}
