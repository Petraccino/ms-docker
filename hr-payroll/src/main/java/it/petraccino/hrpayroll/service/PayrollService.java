package it.petraccino.hrpayroll.service;

import it.petraccino.hrpayroll.entity.Payment;
import it.petraccino.hrpayroll.entity.Worker;
import it.petraccino.hrpayroll.feignclient.WorkerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final WorkerClient workerClient;

    public Payment getPayment(long workerId, int days){
        Worker worker = workerClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
