package com.example.sender.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@ToString
public class ApiErrorResponse {

    String errorMessage;
    HttpStatus httpStatus;
}
