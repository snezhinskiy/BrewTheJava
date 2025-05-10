package org.brewthejava.ping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PingController {
    private final RestTemplate restTemplate;

    @GetMapping(value = "/ping/{threshold}", produces = "application/json")
    public String ping(@PathVariable Double threshold) {
        log.info("Ping received. Threshold: {}", threshold);

        /**
         * Check if the threshold isn't exceeded.
         */
        if (Math.random() < threshold) {
            try {
                String url = "http://localhost:8081/pong/"+threshold;
                return "ping-" + restTemplate.getForObject(url, String.class);
            } catch (Exception e) {
                log.error("Error", e);
            }
        }

        log.info("Threshold exceeded. Game over[ping].");
        return "game over [on the ping side]";
    }

    @PostMapping(value = "/ping", produces = "application/json")
    public String ping(@RequestBody ApiRequest request) {
        log.info("Ping received. Threshold: {}", request);

        /**
         * Check if the threshold isn't exceeded.
         */
        if (Math.random() < request.getThreshold()) {
            try {
                String url = "http://localhost:8081/pong/"+request.getThreshold();
                return "ping-" + restTemplate.getForObject(url, String.class);
            } catch (Exception e) {
                log.error("Error", e);
            }
        }

        log.info("Threshold exceeded. Game over[ping].");
        return "game over [on the ping side]";
    }
}
