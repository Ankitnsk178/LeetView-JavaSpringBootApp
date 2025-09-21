package com.example.LeetcodeProfileFetcher.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @PostMapping("/search")
    public String getResult(@RequestParam("username") String username){
        return "redirect:/api/profile/" + username;
    }

}
