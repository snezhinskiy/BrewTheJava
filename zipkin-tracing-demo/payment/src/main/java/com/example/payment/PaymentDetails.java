package com.example.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDetails {
    private Long invoiceId;
    private Long userId;
    private Double sum;
    private boolean successful;

    public PaymentDetails(Long invoiceId, Long userId, Double sum, boolean successful) {
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.sum = sum;
        this.successful = successful;
    }
}
