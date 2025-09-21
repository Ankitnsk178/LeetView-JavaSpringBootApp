package com.example.LeetcodeProfileFetcher.Service;

import com.example.LeetcodeProfileFetcher.DTO.GraphQLRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileFetcher {

    public String getProfileData(String username){

        String url = "https://leetcode.com/graphql/";
        RestTemplate restTemplate = new RestTemplate();

        String query = """
                query userPublicProfile($username: String!){
                    matchedUser(username: $username) {
                        contestBadge {name
                             expired
                             hoverText
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
                            skillTags
                            postViewCount
                            postViewCountDiff
                            reputation
                            reputationDiff
                            solutionCount
                            solutionCountDiff
                            categoryDiscussCount
                            categoryDiscussCountDiff
                            certificationLevel
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

        String response = restTemplate.postForObject(url, entity, String.class);

        return response;
    }

}
