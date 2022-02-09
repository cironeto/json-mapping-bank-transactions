package dev.cironeto.jsonmapping.service;

import dev.cironeto.jsonmapping.domain.AppUser;
import dev.cironeto.jsonmapping.domain.Role;
import dev.cironeto.jsonmapping.repository.RoleRepository;
import dev.cironeto.jsonmapping.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService  {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(
                appUser.getUsername(),
                appUser.getPassword(),
                authorities);
    }

//    @Transactional
//    public AppUserDto save(AppUserDto dto) {
//        AppUser entity = new AppUser();
//
//        entity.setId(dto.getId());
//        entity.setName(dto.getName());
//        entity.setUsername(dto.getUsername());
//        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
//
//        entity.getRoles().clear();
//        for (RoleDto roleDto : dto.getRoles()) {
//            Role role = roleRepository.getById(roleDto.getId());
//            entity.getRoles().add(role);
//        }
//
//        entity = appUserRepository.save(entity);
//
//        return new AppUserDto(entity);
//    }

    @Transactional
    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Transactional
    public void addRoleToAppUSer(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }


}
