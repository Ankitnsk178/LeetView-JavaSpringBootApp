package com.example.LeetcodeProfileFetcher.DTO.QuestionsDataResponse;

import java.util.List;

@lombok.Data
public class Data {
    private List<AllQuestionsCount> allQuestionsCount;
    private MatchedUser matchedUser;
}
