package com.example.LeetcodeProfileFetcher.Controller;

import com.example.LeetcodeProfileFetcher.DTO.LeetAllData;
import com.example.LeetcodeProfileFetcher.Service.LeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private LeetService leetService;

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @PostMapping("/search")
    public String getResult(@RequestParam("username") String username, Model model){
        LeetAllData leetAllData = leetService.getAllData(username);
        if(leetAllData == null) return "redirect:/?timeOut";
        if(leetAllData.getProfileDataResponse().getData().getMatchedUser() == null) return "redirect:/?notFound";
        model.addAttribute("attendedContest", leetAllData.getContestDataResponse().getData().getUserContestRanking());
        model.addAttribute("leetAllData", leetAllData);
        return "profile";
    }

}
