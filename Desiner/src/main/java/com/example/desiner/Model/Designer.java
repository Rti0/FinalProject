package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


 //   @Column(columnDefinition = "varchar(20) not null ")
    private String name;

  @Column(columnDefinition = "varchar(50) not null ")
    private String username;
 @Column(columnDefinition = "varchar(256) not null ")
    private String password;
   @Email
   @Column(columnDefinition = "varchar(500) not null ")
    private String email;

   @Column(columnDefinition = "varchar(20) not null ")
    private String location;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designer")
    @JsonIgnore
    private Set<Order> orders;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designer")
    //@JsonIgnore
    private Set<Services>servicesSet;


    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "designer")
    private Set<DesignerBusiness>designerBusinesses;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "designer")
    private Set<RateOrder>rateOrders;



}
