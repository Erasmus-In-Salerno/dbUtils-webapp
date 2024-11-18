package com.dbutils_webapp.model;

import lombok.Getter;
import lombok.Setter;

//@
@Setter
@Getter
public class Animal extends Entity {
    private int age;

    private String species;

    public Animal(){
        super();
    }

    public Animal( String name, int age, String species) {
        super();
        this.setName(name);
        this.age = age;
        this.species = species;
    }

}
