package it.petraccino.hruser.service;

import it.petraccino.hruser.entity.User;
import it.petraccino.hruser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
