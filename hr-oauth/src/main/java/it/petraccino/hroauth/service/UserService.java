package it.petraccino.hroauth.service;

import it.petraccino.hroauth.dto.User;
import it.petraccino.hroauth.feignclient.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    public User findByEmail(String email){
        User user = userClient.findByEmail(email).getBody();
        if (user == null){
            throw new IllegalArgumentException();
        }
        return user;
    }
}
