package com.ecommerce.ecommercestore.web.controllers.applicationUser;

import com.ecommerce.ecommercestore.data.model.ApplicationUser;
import com.ecommerce.ecommercestore.data.repository.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApplicationUserController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserController(BCryptPasswordEncoder bCryptPasswordEncoder, ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public BCryptPasswordEncoder encodePassword(){
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/sign-up")
    public void createAccount(@RequestBody ApplicationUser user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}
