package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DesignerBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(500) not null ")
    private String achievement;

    @Column(columnDefinition = "varchar(255) not null ")
    private String body;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "designerId")
    @JsonIgnore
    private Designer designer;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "designerBusiness")
    @PrimaryKeyJoinColumn
    private Image image;

}
