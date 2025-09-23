package com.example.LeetcodeProfileFetcher.DTO.ProfileDataResponse;

import lombok.Data;

@Data
public class MatchedUser {
    private ContestBadge contestBadge;
    private String username;
    private String githubUrl;
    private String twitterUrl;
    private String linkedinUrl;
    private Profile profile;
}
