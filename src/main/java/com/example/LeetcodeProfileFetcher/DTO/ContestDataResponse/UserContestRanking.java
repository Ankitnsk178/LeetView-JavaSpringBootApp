package com.example.LeetcodeProfileFetcher.DTO.ContestDataResponse;

import lombok.Data;

@Data
public class UserContestRanking {
    private Long attendedContestsCount;
    private Double rating;
    private Long globalRanking;
    private Long totalParticipants;
    private Double topPercentage;
}
