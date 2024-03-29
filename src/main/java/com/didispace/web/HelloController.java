package com.didispace.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *@Author chenyun
 * @blog https://blog.csdn.net/sss996
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}