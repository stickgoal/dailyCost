package me.maiz.web;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by Lucas on 2018-01-17.
 */
@Controller
public class HomeController extends BaseController{

    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String toHome(ModelMap modelMap){
        modelMap.addAttribute("username","Lucas");
        List<Map<String,String>> categorys = Lists.newArrayList();
        categorys.add(ImmutableMap.of("name","房租"));
        categorys.add(ImmutableMap.of("name","通讯"));
        modelMap.addAttribute("payCategorys",categorys);
        List<Map<String,String>> recvCategorys = Lists.newArrayList();
        recvCategorys.add(ImmutableMap.of("name","工资"));
        recvCategorys.add(ImmutableMap.of("name","投资"));
        modelMap.addAttribute("recvCategorys",recvCategorys);
        logger.info("访问主页");
        return "home";
    }

}
