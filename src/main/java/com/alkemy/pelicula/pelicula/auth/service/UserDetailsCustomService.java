package com.alkemy.pelicula.pelicula.auth.service;

import com.alkemy.pelicula.pelicula.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

public class UserDetailsCustomService  implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        i (userEntity==null){
            throw new UsernameNotFoundException("Username or password not fount");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList())
    }
    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername);

        }
        return userEntity!= null;
    }
}
