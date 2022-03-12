package com.alkemy.pelicula.pelicula.auth.dto;

import lombok.Data;

//import javax.validation.constraints.Size;
//import java.validation.constraints.Email;

@Data
public class UserDTO {
    @Email(message = "Username must be an email")
    private String username;
    @Size(min = 8)
    private String password;

}
