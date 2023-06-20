package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(255) not null ")
    private String name;
    @Column(columnDefinition = "varchar(256) not null ")
    private String username;
    @Size(min = 2)
    @Column(columnDefinition = "varchar(300) not null")
    private String password;
    @Email
    private String email;

    private String location;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders;

}
