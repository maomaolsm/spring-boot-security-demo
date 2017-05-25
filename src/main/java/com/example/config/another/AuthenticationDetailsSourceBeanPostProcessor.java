package com.example.config.another;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by maomao on 17/5/19.
 */
//@Component
public class AuthenticationDetailsSourceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UsernamePasswordAuthenticationFilter) {
            ((UsernamePasswordAuthenticationFilter)bean).setAuthenticationDetailsSource(
                new WebAuthenticationDetailsSource() {
                    @Override
                    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
                        return new MyAuthenticationDetails(context);
                    }
                }
            );
        }

        return bean;
    }
}
