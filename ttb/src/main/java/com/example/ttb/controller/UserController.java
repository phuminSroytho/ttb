package com.example.ttb.controller;


import com.example.ttb.model.response.V1GetUserResponse;
import com.example.ttb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Validated
public class UserController {

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private UserService userService;

    @GetMapping("/v1/ttb/user")
    public ResponseEntity<List<V1GetUserResponse>> getUser(
            @RequestParam @NonNull String customerId
    ) {
        HttpHeaders newHttpHeaders = new HttpHeaders();
        newHttpHeaders.addAll(httpHeaders);

        return new ResponseEntity<>(
                userService.getUser(customerId),
                newHttpHeaders,
                HttpStatus.OK
        );
    }
}
