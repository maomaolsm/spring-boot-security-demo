package com.example.config.another;

import groovy.util.logging.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by maomao on 17/5/12.
 */
//@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);
        User user=new User("mao","mao",grantedAuthorities);
        return user;
    }
}
