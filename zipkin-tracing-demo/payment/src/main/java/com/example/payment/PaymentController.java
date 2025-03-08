package com.example.payment;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final CommunicationService communicationService;

    @GetMapping(
        value="/payment/process/{invoiceId}",
        produces = "application/json"
    )
    public PaymentDetails processPayment(@PathVariable Long invoiceId) {
        Double sum = communicationService.getInvoiceSum(invoiceId);
        Long userId = communicationService.getUserId();

        if (communicationService.reserve(invoiceId, userId)) {
            PaymentDetails details = new PaymentDetails(invoiceId, userId, sum, true);
            log.info("Payment processed: {}", details);
            return details;
        }

        log.warn("payment processing failed");
        return new PaymentDetails(invoiceId, userId, sum, false);
    }
}
