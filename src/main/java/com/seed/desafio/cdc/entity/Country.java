package com.seed.desafio.cdc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    public Country(){}
    public Country(String id){
        this.id = id;
    }

    public Country(String id, String name){
        this.id = id;
        this.name = name;
    }
}
