package dev.cironeto.jsonmapping.util;

import dev.cironeto.jsonmapping.domain.Role;
import dev.cironeto.jsonmapping.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleFactory {
    private final RoleRepository roleRepository;

    public void createAndPersistRoles() {
        roleRepository.save(Role.builder().id(1L).name("ROLE_ADMIN").build());
    }
}
