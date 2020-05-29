package com.millertronics.otm.authorizationservice.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl extends User implements UserDetails {

    public UserDetailsImpl(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        getRoles().forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            grantedAuthorities.addAll(role.getPermissions().stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                    .collect(Collectors.toList()));
        });
        return grantedAuthorities;
    }
}
