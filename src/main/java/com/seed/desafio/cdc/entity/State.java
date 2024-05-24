package com.seed.desafio.cdc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;


    public State(){}
    public State(String name, Country country){
        this.name = name;
        this.country = country;
    }

    public State(String id,String name, Country country){
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
