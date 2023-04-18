package com.goit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

//@Controller
//public class TestControler {
//
//    @ResponseBody
//    @GetMapping("/test")
//    public String testMethod() {
//        String result = "Hi!";
//        return result;
//    }
//}

@Controller
public class TestControler {
    @GetMapping("/test")
    public ModelAndView testMethod() {
        ModelAndView result = new ModelAndView("test");
        return result;
    }
}