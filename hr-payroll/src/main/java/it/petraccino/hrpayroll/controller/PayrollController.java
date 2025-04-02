package it.petraccino.hrpayroll.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import it.petraccino.hrpayroll.entity.Payment;
import it.petraccino.hrpayroll.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    @CircuitBreaker(name = "getPayment", fallbackMethod = "getPaymentAlternative")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days, Throwable throwable) {
        Payment payment = new Payment("Not found", 0.0, 0);
        return ResponseEntity.ok(payment);
    }
}
