package com.example.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CommunicationService {
    private final RestTemplate restTemplate;

    public Double getInvoiceSum(Long invoiceId) {
        String url = "http://localhost:8081/get-sum/"+invoiceId;
        return restTemplate.getForObject(url, Double.class);
    }

    public Long getUserId() {
        String url = "http://localhost:8084/get-user-id";
        return restTemplate.getForObject(url, Long.class);
    }

    public boolean reserve(Long invoiceId, Long userId) {
        String url = "http://localhost:8082/reserve/"+invoiceId+"/"+userId;
        return Boolean.TRUE.equals(
            restTemplate.getForObject(url, Boolean.class)
        );
    }
}
