package it.petraccino.hrworker.controller.service;

import it.petraccino.hrworker.entity.Worker;
import it.petraccino.hrworker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;

    public List<Worker> findAll(){
        return repository.findAll();
    }

    public Worker findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
