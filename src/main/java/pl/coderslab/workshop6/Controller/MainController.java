package pl.coderslab.workshop6.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.Column;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hellow() { return "redirect:/login"; }
}
