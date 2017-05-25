package com.example.config.another;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class MyAuthenticationDetails extends WebAuthenticationDetails {

    public enum Origin {
        USER,
        PLATFORM,
    }

    private Origin origin;

    public MyAuthenticationDetails(HttpServletRequest request) {
        super(request);

        try {
            log.info("username is : {} , password is : {} , origin is : {}", request.getParameter("username"), request.getParameter("password"), request.getParameter("origin"));
            origin = Origin.valueOf(request.getParameter("origin").toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("origin not exist");
            throw new UsernameNotFoundException("Parameter 'origin' must be provided.");
        }
    }

    public Origin getOrigin() {
        return this.origin;
    }

}
