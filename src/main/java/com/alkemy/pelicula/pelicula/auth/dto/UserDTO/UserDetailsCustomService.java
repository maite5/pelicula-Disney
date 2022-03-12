package com.alkemy.pelicula.pelicula.auth.dto.UserDTO;

import com.alkemy.pelicula.pelicula.auth.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsCustomService implements  UserDetailsService{
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Override
    public UserDetails loadByUsername(String username) throws  UsernameNotFoundException{
        UserEntity userEntity= userRepository.findByUsername(userName);
        if(userEntity==null){
            throw new UsernameNotFoundException("Username or passwod not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
    public  boolean save(UserDTO userDTO){
        UserEntity userEntity= new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        if(userEntity!= null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }
}
