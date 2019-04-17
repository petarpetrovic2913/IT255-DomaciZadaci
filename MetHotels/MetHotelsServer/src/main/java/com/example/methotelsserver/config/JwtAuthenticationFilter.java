package com.example.methotelsserver.config;

import com.example.methotelsserver.model.User;
import com.example.methotelsserver.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.methotelsserver.config.SecurityConstants.HEADER_STRING;
import static com.example.methotelsserver.config.SecurityConstants.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{

            String jwt = getJwtFromRequest(httpServletRequest);

            if(StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)){
                Long id = tokenProvider.getCustomerIdFromJWT(jwt);
                User user = userService.loadUserById(id);

                //Collections.emptyList() before the roles are added

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        user,null , null
                );

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }catch(Exception ex){
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER_STRING);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7,bearerToken.length());
        }

        return null;
    }

}
