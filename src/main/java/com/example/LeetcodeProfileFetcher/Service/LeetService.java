package com.example.LeetcodeProfileFetcher.Service;

import com.example.LeetcodeProfileFetcher.DTO.LeetAllData;
import com.example.LeetcodeProfileFetcher.DTO.ProfileDataResponse.ProfileDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeetService {

    @Autowired
    private ProfileFetcher profileFetcher;

    public LeetAllData getAllData(String username){

        LeetAllData leetAllData = new LeetAllData();

        ProfileDataResponse profileDataResponse = profileFetcher.getProfileData(username);
        if(profileDataResponse == null) return null;

        leetAllData.setProfileDataResponse(profileDataResponse);

        if(leetAllData.getProfileDataResponse().getData().getMatchedUser() == null) return leetAllData;

        leetAllData.setQuestionDataResponse(profileFetcher.getQuestionsData(username));
        leetAllData.setContestDataResponse(profileFetcher.getContestData(username));
        leetAllData.setBadgesDataResponse(profileFetcher.getBadgesData(username));
        leetAllData.setRecentDataResponse(profileFetcher.getRecentData(username));

        return leetAllData;
    }

}
