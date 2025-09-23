package com.example.LeetcodeProfileFetcher.DTO;

import com.example.LeetcodeProfileFetcher.DTO.BadgesDataResponse.BadgesDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.ContestDataResponse.ContestDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.ProfileDataResponse.ProfileDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.QuestionsDataResponse.QuestionDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.RecentDataResponse.RecentDataResponse;
import lombok.Data;

@Data
public class LeetAllData {

    private ProfileDataResponse profileDataResponse;
    private QuestionDataResponse questionDataResponse;
    private ContestDataResponse contestDataResponse;
    private BadgesDataResponse badgesDataResponse;
    private RecentDataResponse recentDataResponse;

}
