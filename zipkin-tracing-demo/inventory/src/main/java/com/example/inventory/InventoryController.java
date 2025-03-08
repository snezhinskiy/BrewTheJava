package com.example.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InventoryController {

    @GetMapping(
        value = "/reserve/{invoiceId}/{userId}",
        produces = "application/json"
    )
    public Boolean reserve(@PathVariable Long invoiceId, @PathVariable Long userId) {
        log.info("got request with invoiceId={}, userId={}", invoiceId, userId);
        final Boolean result = Math.random() > 0.5;
        log.info("result={}", result);
        return result;
    }
}
