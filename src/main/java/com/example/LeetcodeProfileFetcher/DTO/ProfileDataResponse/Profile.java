package com.example.LeetcodeProfileFetcher.DTO.ProfileDataResponse;

import lombok.Data;

import java.util.List;

@Data
public class Profile {
    private Long ranking;
    private String userAvatar;
    private String realName;
    private String aboutMe;
    private String school;
    List<String> websites;
    private String countryName;
    private String company;
    private String jobTitle;
    private Long postViewCount;
    private Long reputation;
    private Long solutionCount;
    private Long categoryDiscussCount;
}
