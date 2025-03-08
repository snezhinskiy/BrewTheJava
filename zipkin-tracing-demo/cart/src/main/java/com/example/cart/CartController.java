package com.example.cart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class CartController {

    @GetMapping(value = "/get-sum/{invoiceId}", produces = "application/json")
    public Double getSum(@PathVariable Long invoiceId, @RequestHeader Map<String, String> headers) {
        log.info("got request with invoiceId={}", invoiceId);

        final Double sum = Math.round(Math.random()*10000)/100.0;
        log.info("sum for invoiceId={}, is={}", invoiceId, sum);

        return sum;
    }
}
