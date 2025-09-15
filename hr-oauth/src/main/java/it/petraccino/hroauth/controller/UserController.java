package it.petraccino.hroauth.controller;

import it.petraccino.hroauth.dto.User;
import it.petraccino.hroauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oauth")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "/email")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = service.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
