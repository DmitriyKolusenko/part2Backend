package com.tsystems.tshop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logout1")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getRsp() {
        return "Logout is completed";
    }
}
