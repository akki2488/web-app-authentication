package com.bss.auth.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Akshay Misra on 14-11-2018.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        System.out.println("JwtAuthenticationEntryPoint commence, SC_UNAUTHORIZED, URL: "+request.getRequestURI());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        request.getRequestDispatcher("/").forward(request, response);
    }
}