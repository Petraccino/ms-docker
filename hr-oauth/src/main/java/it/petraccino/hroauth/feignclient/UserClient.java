package it.petraccino.hroauth.feignclient;

import it.petraccino.hroauth.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

    @GetMapping(value = "/by-email")
    User findByEmail(@RequestParam String email);

}