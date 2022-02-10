package dev.cironeto.jsonmapping.util;

import dev.cironeto.jsonmapping.domain.AppUser;
import dev.cironeto.jsonmapping.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@RequiredArgsConstructor
@Component
public class AppUserFactory {
    private final AppUserService userService;

    public void createAndPersistUsersDto() {
        userService.save(AppUser.builder()
                .id(123L)
                .userKey("8a85867e6ad9e761016ada958bdf5b0f")
                .name("William")
                .username("william")
                .password("123")
                .roles(new HashSet<>())
                .build());

        userService.save(AppUser.builder()
                .id(890L)
                .userKey("8a8587b371776b9e01717d217e6e1492")
                .name("David")
                .username("david")
                .password("123")
                .roles(new HashSet<>())
                .build());

        userService.save(AppUser.builder()
                .id(10L)
                .userKey("8a8587fd6b0487a7016b07a1ecfb0b74")
                .name("Ciro")
                .username("ciro")
                .password("123")
                .roles(new HashSet<>())
                .build());
    }

}
