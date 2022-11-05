package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 메인화면
    @GetMapping(value = "/")
    public String main() {
        return "main";
    }
}
