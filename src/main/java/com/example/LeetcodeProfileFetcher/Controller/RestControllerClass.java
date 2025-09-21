package com.example.LeetcodeProfileFetcher.Controller;

import com.example.LeetcodeProfileFetcher.Service.ProfileFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

    @Autowired
    private ProfileFetcher profileFetcher;

    @GetMapping("/api/profile/{username}")
    public ResponseEntity<String> getProfile(@PathVariable("username") String username){
        String profile = profileFetcher.getProfileData(username);
        return ResponseEntity.ok(profile);
    }

}
