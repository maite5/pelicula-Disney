package com.alkemy.pelicula.pelicula.auth.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class jwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws ServletException, IOException{
        final String authorizationHeader = request.getHeader( "Authorization");
        String username = null;
        String jwt = null;
        if( authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            jwt= authorizationHeader.substring(7);
            username= jwtUtil.extractUsername(jwt);
        }
        if(username != null && SecurityContextHolder.getContenxt().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsCustomService.loadUserByUsername(username);
            if (jwtUtil.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authReq =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                Authentication auth = authenticationManager.authenticate(authReq);
                //Set auth in context
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
            chain.doFilter(request, response);
    }

}
