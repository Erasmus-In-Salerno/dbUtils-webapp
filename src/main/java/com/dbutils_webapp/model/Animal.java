package com.dbutils_webapp.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Animal {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    //@Column
    public String name;

    //@Column
    public int age;

    //@Column
    public String species;
}
