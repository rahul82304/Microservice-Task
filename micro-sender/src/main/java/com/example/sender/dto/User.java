package com.example.sender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @NotBlank(message = "First name is mandatory")
    String firstName;
    String lastName;
}
