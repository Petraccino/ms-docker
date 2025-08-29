package it.petraccino.hruser.controller;

import it.petraccino.hruser.dto.UserDTO;
import it.petraccino.hruser.entity.User;
import it.petraccino.hruser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/by-email")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email){
        UserDTO user = service.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
