package it.petraccino.hruser.dto;

import it.petraccino.hruser.entity.Role;
import it.petraccino.hruser.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<String> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles()
                .stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());
    }

}
