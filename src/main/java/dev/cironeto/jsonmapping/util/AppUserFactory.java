package dev.cironeto.jsonmapping.util;

import dev.cironeto.jsonmapping.domain.AppUser;
import dev.cironeto.jsonmapping.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@RequiredArgsConstructor
@Component
public class AppUserFactory {
    private final AppUserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void createAndPersistUsersDto() {
        userService.save(AppUser.builder()
                .id("8a85867e6ad9e761016ada958bdf5b0f")
                .name("William")
                .username("william")
                .password(passwordEncoder.encode("123"))
                .roles(new HashSet<>())
                .build());

        userService.save(AppUser.builder()
                .id("8a8587b371776b9e01717d217e6e1492")
                .name("David")
                .username("david")
                .password(passwordEncoder.encode("123"))
                .roles(new HashSet<>())
                .build());

        userService.save(AppUser.builder()
                .id("8a8587fd6b0487a7016b07a1ecfb0b74")
                .name("Ciro")
                .username("cironeto")
                .password(passwordEncoder.encode("123"))
                .roles(new HashSet<>())
                .build());
    }


//    public void createAndPersistUsersDto() {
//        userService.save(AppUserDto.builder()
//                .id("8a85867e6ad9e761016ada958bdf5b0f")
//                .name("William")
//                .username("william@dev")
//                .password(passwordEncoder.encode("123456"))
//                .roles(new HashSet<>())
//                .build());
//
//        userService.save(AppUserDto.builder()
//                .id("8a8587b371776b9e01717d217e6e1492")
//                .name("David")
//                .username("david@dev")
//                .password(passwordEncoder.encode("123456"))
//                .roles(new HashSet<>())
//                .build());
//
//        userService.save(AppUserDto.builder()
//                .id("8a8587fd6b0487a7016b07a1ecfb0b74")
//                .name("Ciro")
//                .username("ciro@dev")
//                .password(passwordEncoder.encode("123456"))
//                .roles(new HashSet<>())
//                .build());
//    }


}
