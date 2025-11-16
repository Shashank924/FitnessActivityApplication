package com.fitness.activityservice.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Service
public class UserValidationService {
    @Autowired
    private WebClient userServiceWebClient;

    public boolean validateUserById(int id) {
        try {
            return userServiceWebClient.get()
                    .uri("/api/user/validate/{id}" , id)
                    .retrieve()
                    .bodyToMono(Boolean.class).block();
        } catch (WebClientResponseException e) {
            System.out.println(e);
            return false;
        }
    }
}
