package com.graphql.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Integer age;

    // relación de muchos a uno

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
    private Course course;


}
