package it.petraccino.hroauth.service;

import it.petraccino.hroauth.dto.User;
import it.petraccino.hroauth.feignclient.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User dto = userClient.findByEmail(email);
        if (dto == null) throw new UsernameNotFoundException(email);

        List<SimpleGrantedAuthority> auths = dto.getRoles().stream()
                .map(SimpleGrantedAuthority::new).toList();

        return org.springframework.security.core.userdetails.User
                .withUsername(dto.getEmail())
                .password(dto.getPassword())
                .authorities(auths)
                .build();
    }
}
