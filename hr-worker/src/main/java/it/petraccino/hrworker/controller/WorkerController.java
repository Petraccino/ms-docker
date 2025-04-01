package it.petraccino.hrworker.controller;

import it.petraccino.hrworker.controller.service.WorkerService;
import it.petraccino.hrworker.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService service;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = service.findById(id);
        return ResponseEntity.ok(worker);
    }

}
