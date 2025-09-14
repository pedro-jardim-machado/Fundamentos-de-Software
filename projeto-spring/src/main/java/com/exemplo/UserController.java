package com.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.zip.DataFormatException;

@RestController
public class UserController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("criarusuario")
    public String criarUsuario(@RequestParam(value = "username") String username, @RequestParam(value= "password") String password, @RequestParam(value= "role") String role) throws Exception {
        if (userDetailsManager.userExists(username)) {
            throw new DataFormatException("esse username já está cadastrado");
        }
        if (!role.equals("BIBLIOTECARIO") && !role.equals("USER")) {
            throw new DataFormatException("role invalida deve ser ou BIBLIOTECARIO ou USER");
        }
        UserDetails user = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles(role)
                .build();
        userDetailsManager.createUser(user);
        return "Usuário criado com sucesso!";
    }
}

