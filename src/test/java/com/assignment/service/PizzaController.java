package com.assignment.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PizzaController {

    @RequestMapping("/root")
    public @ResponseBody String greeting() {
        return "Root context for the pizza service";
    }

}
