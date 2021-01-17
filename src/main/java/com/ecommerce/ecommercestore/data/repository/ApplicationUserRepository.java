package com.ecommerce.ecommercestore.data.repository;

import com.ecommerce.ecommercestore.data.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    ApplicationUser findUserByUsername(String username);
}
