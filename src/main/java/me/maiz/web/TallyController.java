package me.maiz.web;

import me.maiz.web.form.TallyForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Lucas on 2017-03-13.
 */
@Controller
public class TallyController extends BaseController {

    @RequestMapping("tally")
    public String keep(TallyForm form){
        logger.info(form.toString());
        return "redirect:home";
    }



}
