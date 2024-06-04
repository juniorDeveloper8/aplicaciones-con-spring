package com.validaciones.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    // relacion
    @OneToMany(targetEntity = Employes.class, fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employes> employesList;
}
