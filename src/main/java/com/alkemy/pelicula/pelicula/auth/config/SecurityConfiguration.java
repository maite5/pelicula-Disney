package com.alkemy.pelicula.pelicula.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.naming.AuthenticationException;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    protected  void configure(AuthenticationManegerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsCustomService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEneeder.getInstance();
    }
    @Override
    @Bean
    public AuthentionManager authentionManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Override
    protected  void configure(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity. csrf().disable()
                .authorizeRequests().antMatchers("/auth/*/").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy. STATELESS);
        httpSecurity.addFilterBefore(jwRequestFilter), UsernamePasswordAuthenticacionFilter.class);
    }
}
