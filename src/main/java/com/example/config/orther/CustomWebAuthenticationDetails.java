package com.example.config.orther;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maomao on 17/5/22.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private final String source;

    /**
     * Records the remote address and will also set the session Id if a session already
     * exists (it won't create one).
     *
     * @param request that the authentication request was received from
     */
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        source = request.getParameter("source");
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; source: ").append(this.getSource());
        return sb.toString();
    }
}
