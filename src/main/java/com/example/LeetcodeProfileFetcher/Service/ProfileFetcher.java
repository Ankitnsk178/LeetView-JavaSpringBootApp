package com.example.LeetcodeProfileFetcher.Service;

import com.example.LeetcodeProfileFetcher.DTO.BadgesDataResponse.Badges;
import com.example.LeetcodeProfileFetcher.DTO.BadgesDataResponse.BadgesDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.BadgesDataResponse.MatchedUser;
import com.example.LeetcodeProfileFetcher.DTO.ContestDataResponse.ContestDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.GraphQLRequest;
import com.example.LeetcodeProfileFetcher.DTO.ProfileDataResponse.ProfileDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.QuestionsDataResponse.QuestionDataResponse;
import com.example.LeetcodeProfileFetcher.DTO.RecentDataResponse.RecentDataResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileFetcher {

    private String url = "https://leetcode.com/graphql/";


    public ProfileDataResponse getProfileData(String username){

        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query userPublicProfile($username: String!){
                    matchedUser(username: $username) {
                        contestBadge {
                            name
                            icon
                        }
                        username
                        githubUrl
                        twitterUrl
                        linkedinUrl
                        profile {
                            ranking
                            userAvatar
                            realName
                            aboutMe
                            school
                            websites
                            countryName
                            company
                            jobTitle
                            postViewCount
                            reputation
                            solutionCount
                            categoryDiscussCount
                        }
                    }
                }
                """;

        Map<String,Object> variables = new HashMap<>();
        variables.put("username",username);

        GraphQLRequest request = new GraphQLRequest(query, variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphQLRequest> entity = new HttpEntity<>(request,headers);

        ProfileDataResponse profileDataResponse = null;

        try {
            profileDataResponse = restTemplate.postForObject(url, entity, ProfileDataResponse.class);
        }
        catch (Exception e){
            return null;
        }

        //String response = restTemplate.postForObject(url, entity, String.class);

        return profileDataResponse;
    }



    public QuestionDataResponse getQuestionsData(String username){

        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query userSessionProgress($username: String!) {
                        allQuestionsCount {
                            difficulty
                            count
                        }
                        matchedUser(username: $username) {
                            submitStats {
                                acSubmissionNum {
                                    difficulty
                                    count
                                }
                
                            }
                        }
                }
                """;

        Map<String,Object> variables = new HashMap<>();
        variables.put("username",username);

        GraphQLRequest request = new GraphQLRequest(query,variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphQLRequest> entity = new HttpEntity<>(request, headers);

        QuestionDataResponse questionDataResponse = restTemplate.postForObject(url, entity, QuestionDataResponse.class);

        return  questionDataResponse;
    }



    public ContestDataResponse getContestData(String username){

        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query userContestRankingInfo($username: String!) {
                    userContestRanking(username: $username) {
                        attendedContestsCount
                        rating
                        globalRanking
                        totalParticipants
                        topPercentage
                    }
                }
                """;

        Map<String,Object> variables = new HashMap<>();
        variables.put("username", username);

        GraphQLRequest graphQLRequest = new GraphQLRequest(query, variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphQLRequest> entity = new HttpEntity<>(graphQLRequest, headers);

        ContestDataResponse contestDataResponse = restTemplate.postForObject(url, entity, ContestDataResponse.class);

        return contestDataResponse;
    }



    public BadgesDataResponse getBadgesData(String username){

        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query userBadges($username: String!) {
                    matchedUser(username: $username) {
                        badges {
                            displayName
                            icon
                            creationDate
                        }
                    }
                }
                """;

        Map<String,Object> variables = new HashMap<>();
        variables.put("username", username);

        GraphQLRequest graphQLRequest = new GraphQLRequest(query, variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphQLRequest> entity = new HttpEntity<>(graphQLRequest, headers);

        BadgesDataResponse badgesDataResponse = restTemplate.postForObject(url, entity, BadgesDataResponse.class);

        MatchedUser matchedUser = new MatchedUser();

        for(Badges b : badgesDataResponse.getData().getMatchedUser().getBadges()){
            String temp = b.getIcon();
            if(!temp.startsWith("https")){
                b.setIcon("https://leetcode.com" + temp);
            }
        }

        return badgesDataResponse;
    }


    public RecentDataResponse getRecentData(String username){

        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query recentAcSubmissions($username: String!, $limit: Int!) {
                    recentAcSubmissionList(username: $username, limit: $limit) {
                        title
                        titleSlug
                    }
                }
                """;

        Map<String,Object> variables = new HashMap<>();
        variables.put("username", username);
        variables.put("limit", 5);

        GraphQLRequest graphQLRequest = new GraphQLRequest(query, variables);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GraphQLRequest> entity = new HttpEntity<>(graphQLRequest, headers);

        RecentDataResponse recentDataResponse = restTemplate.postForObject(url, entity, RecentDataResponse.class);

        return  recentDataResponse;
    }

}