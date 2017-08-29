package com.cyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/23.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/{page}")
    public String page(@PathVariable("page")String page) {
        return page;
    }
}
