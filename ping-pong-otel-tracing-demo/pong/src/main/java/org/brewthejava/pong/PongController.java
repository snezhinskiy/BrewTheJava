package org.brewthejava.pong;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PongController {
    private final RestTemplate restTemplate;

    @GetMapping(value = "/pong/{threshold}", produces = "application/json")
    public String ping(@PathVariable Double threshold) {
        log.info("Pong received. Threshold: {}", threshold);

        /**
         * Check if the threshold isn't exceeded.
         */
        if (Math.random() < threshold) {
            try {
                String url = "http://localhost:8080/ping/"+threshold;
                return "pong-" + restTemplate.getForObject(url, String.class);
            } catch (Exception e) {
                log.error("Error", e);
            }
        }

        log.info("Threshold exceeded. Game over[pong].");
        return "game over [on the pong side]";
    }
}
