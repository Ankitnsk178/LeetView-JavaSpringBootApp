package com.example.LeetcodeProfileFetcher.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GraphQLRequest {
    private String query;
    private Map<String,Object> variables;

    public GraphQLRequest(String query, Map<String,Object> variables){
        this.query = query;
        this.variables = variables;
    }

}
