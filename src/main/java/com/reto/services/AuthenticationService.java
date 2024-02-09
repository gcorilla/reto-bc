package com.reto.services;

import com.reto.model.UserModel;
import com.reto.payload.AuthenticationLogin;
import com.reto.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public AuthenticationService(
            IUserRepository userRepository,
            AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public UserModel authenticate(AuthenticationLogin login) {
        logger.info("AUTHENTICATION: {}", login);
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getCellphone(),
                            login.getPassword()
                    )
            );
            logger.error("AUTHENTICATION: User Authenticated");
            return userRepository.findUserModelByCellphone(login.getCellphone());
        }catch (Exception e){
            logger.error("AUTHENTICATION ERROR: {}",e.getMessage());
            return null;

        }

    }
}
