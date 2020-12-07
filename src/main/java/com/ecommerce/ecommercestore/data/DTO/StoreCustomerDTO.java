package com.ecommerce.ecommercestore.data.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StoreCustomerDTO {
    private Integer id;

    private String fname;

    private String lname;

    private String email;

    private String contact;

    private String password;
}
