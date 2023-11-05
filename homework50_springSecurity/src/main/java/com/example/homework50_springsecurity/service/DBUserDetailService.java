package com.example.homework50_springsecurity.service;

import com.example.homework50_springsecurity.domain.PermissionEntity;
import com.example.homework50_springsecurity.domain.PersonEntity;
import com.example.homework50_springsecurity.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class DBUserDetailService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<PersonEntity> userOpt = personRepository.findByUserName(username);

        if (userOpt.isEmpty()) {
            throw new RuntimeException();
        }

        PersonEntity personEntity = userOpt.get();
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {

                List<PermissionEntity> permissionEntityList = personEntity.getPermissionEntityList();

                if (permissionEntityList == null || permissionEntityList.size() == 0) {
                    return new ArrayList<>();
                }

                List<GrantedAuthority> collect = permissionEntityList.stream()
                        .map(permissionEntity -> permissionEntity.getName())
                        .map(name -> new GrantedAuthority() {
                            @Override
                            public String getAuthority() {
                                return name;
                            }
                        })
                        .collect(Collectors.toList());

                return collect;
            }

            @Override
            public String getPassword() {
                return personEntity.getPassword();
            }

            @Override
            public String getUsername() {
                return personEntity.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return personEntity.getIsEnabled();
            }
        };
    }
}
