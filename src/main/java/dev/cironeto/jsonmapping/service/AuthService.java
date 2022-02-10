package dev.cironeto.jsonmapping.service;

import dev.cironeto.jsonmapping.domain.AppUser;
import dev.cironeto.jsonmapping.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AppUserRepository appUserRepository;

    public AppUser getAuthenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username);
    }
}
