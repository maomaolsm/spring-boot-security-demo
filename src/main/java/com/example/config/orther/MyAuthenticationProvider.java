package com.example.config.orther;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by maomao on 17/5/22.
 */
@Service
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomWebAuthenticationDetails customWebAuthenticationDetails = (CustomWebAuthenticationDetails) authentication.getDetails();

        String source = customWebAuthenticationDetails.getSource();
        log.info("登录来源：------>{}", source);
        log.info("user name: {}", authentication.getName());
        log.info("password: {}", authentication.getCredentials());
        log.info("getPrincipal: {}", authentication.getPrincipal());
        log.info("getAuthorities: {}", authentication.getAuthorities());
        log.info("getDetails: {}", authentication.getDetails());

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);

        //TODO add private authentication mechanism

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            authentication.getPrincipal(), authentication.getCredentials(), grantedAuthorities
        );
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
