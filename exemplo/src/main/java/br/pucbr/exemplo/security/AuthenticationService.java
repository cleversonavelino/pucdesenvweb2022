package br.pucbr.exemplo.security;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public User authenticate(LoginUserDto input) {
        //todo validar se o usuário existe no banco
        return new User();
    }

}
