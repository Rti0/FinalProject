package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "myOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(200)  not null ")
    private String description;

    @Column(columnDefinition = "int not null ")
    private Integer totalPrice;

    @Column(columnDefinition = "int not null ")
    private Integer area;

   // @Pattern(regexp = "\\b(?:notStarted|inProgress|Done)\\b",message = "status Not Valid")
    @Column(columnDefinition = "varchar(200) not null check( status='notStarted' or status='inProgress' or status='Done' )")
    private String status;





    @ManyToOne
            //(cascade = CascadeType.ALL)
    @JoinColumn(name = "designerId")
    @JsonIgnore
    private Designer designer;



    @ManyToOne
            //(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "order")
    @PrimaryKeyJoinColumn
    private RateOrder rateOrder;

    @ManyToMany
    @JsonIgnore
    private Set<Services> services;

}
