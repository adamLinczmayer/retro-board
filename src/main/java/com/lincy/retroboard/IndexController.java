package com.lincy.retroboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Adam Linczmayer
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}