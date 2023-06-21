package com.example.desiner.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomerDTO {


    private Integer user_id;
    private String username;

    private String password;
    private String name;

    private String email;

    private String location;

}
