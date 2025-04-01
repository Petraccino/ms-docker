package it.petraccino.hrpayroll.service;

import it.petraccino.hrpayroll.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayrollService {

    public Payment getPayment(long workerId, int days){
        return new Payment("Bob", 200.0, days);
    }

}
