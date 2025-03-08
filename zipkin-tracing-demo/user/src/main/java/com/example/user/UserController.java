package com.example.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping(value="/get-user-id", produces = "application/json")
    public Long getUserId() {
        Long userId = Math.round(Math.random()*1000);
        log.info("userId={}", userId);
        return userId;
    }
}
