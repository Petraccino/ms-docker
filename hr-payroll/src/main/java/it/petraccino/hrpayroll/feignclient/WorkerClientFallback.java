package it.petraccino.hrpayroll.feignclient;

import it.petraccino.hrpayroll.entity.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerClientFallback implements WorkerClient{
    @Override
    public ResponseEntity<Worker> findById(Long id) {
        return ResponseEntity.ok(new Worker(id, "Not Found client", 0.0));
    }
}
