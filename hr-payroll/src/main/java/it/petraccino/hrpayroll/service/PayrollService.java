package it.petraccino.hrpayroll.service;

import it.petraccino.hrpayroll.entity.Payment;
import it.petraccino.hrpayroll.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PayrollService {

    @Value("${hr-worker.host}")
    private String host;
    private final RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days){
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", ""+workerId);
        Worker worker = restTemplate.getForObject(host+"/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
