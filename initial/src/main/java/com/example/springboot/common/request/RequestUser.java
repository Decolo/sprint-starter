package com.example.springboot.common.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUser {

    @NotNull
    @JsonProperty
    @Size(max = 20)
    private String name;
    
    @NotNull
    @JsonProperty
    private String email;

}
