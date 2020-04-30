package com.sahibinden.devakademi.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.List;

@Getter
@Setter
public class ResponseError {


    private HttpStatus status;

    private String message;

    private List<String> details;

    public ResponseError(HttpStatus status, String message, List<String> details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

}
