package com.example.learn.angular.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @JsonProperty("userId")
    private Long id;

    @JsonProperty("userName")
    private String username;

    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("userDescription")
    private String shortDescription;

}
