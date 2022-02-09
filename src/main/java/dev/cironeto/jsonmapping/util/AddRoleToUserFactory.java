package dev.cironeto.jsonmapping.util;

import dev.cironeto.jsonmapping.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddRoleToUserFactory {
    private final AppUserService appUserService;

    public void addRoles() {

    }
}
