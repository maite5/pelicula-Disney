package com.alkemy.pelicula.pelicula.auth.controller;

import com.alkemy.pelicula.pelicula.auth.service.JwtUtils;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/auth")
public class UserAuthController {
    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;

    @Autowired
    public UserAuthController(
            UserDetailsCustomService userDetailsService;
            AuthenticationManager authenticationManager;
            JwtUtils jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokeUtil = jwtTokenUtil;
    }
    @

    PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse>(
    @Valid
    @RequestBody
    UserDTO user)throws

    Exception {
        this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @

    PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse>(
    @RequestBody
    AuthenticationRequest authRequest throws Exception)
    UserDetails userDetails;
    try

    {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        userDetails = (UserDetails) auth.getPrincipal();
    } catch(BadCredentialsException e) {

    {
        throw new Exception("Incorrect username o password", e);
    }

    final String jwt = jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));


}
}


