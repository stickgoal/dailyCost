package me.maiz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lucas on 2018-01-15.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(ModelMap modelMap){
        return "index";
    }


}
