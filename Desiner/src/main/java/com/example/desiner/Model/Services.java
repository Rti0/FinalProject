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
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(200)  not null ")
    private String name;


    @Column(columnDefinition = "varchar(200) not null check( category='Interior' or category='Exterior')")
    private String category;


    @Column(columnDefinition = "varchar(200)  not null ")
    private String description;


    @Column(columnDefinition = "int not null ")
    private Integer price;




    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "designerId")
    @JsonIgnore
    private Designer designer;

    @ManyToMany(mappedBy = "services")
    @JsonIgnore
    private Set<Order> orders;

}
