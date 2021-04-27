package com.chenhan.mytravelsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author Han HA Chen
 * @Date 27/04/2021 15:41
 **/

@Controller
public class testController {


    @GetMapping("test")
    public String index() {
        return "index";
    }


}
