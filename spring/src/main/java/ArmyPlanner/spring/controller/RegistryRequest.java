package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.domain.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistryRequest {

    private String username;
    private String password;
    private Role role = Role.ROLE_MEMBER;
}
