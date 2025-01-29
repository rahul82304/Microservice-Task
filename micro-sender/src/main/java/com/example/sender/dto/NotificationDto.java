package com.example.sender.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {

    @Valid
    User user;
    @NotBlank(message = "Message is mandatory")
    String message;
}
