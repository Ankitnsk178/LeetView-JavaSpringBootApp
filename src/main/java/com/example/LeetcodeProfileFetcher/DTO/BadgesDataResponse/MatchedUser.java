package com.example.LeetcodeProfileFetcher.DTO.BadgesDataResponse;

import lombok.Data;

import java.util.List;

@Data
public class MatchedUser {
    private List<Badges> badges;
}
