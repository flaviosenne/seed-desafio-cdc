package com.seed.desafio.cdc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Getter
    private String name;

    private String email;

    @Column(name = "created_at")
    private Date createdAt;

    private String description;

    public Author(){

    }


    public Author(String id){
        this.id = id;
    }
    public Author(String id, String name, String email, Date createdAt, String description){
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.description = description;
    }

    public Author(String name, String email, String description){
        this.name = name;
        this.email = email;
        this.createdAt = new Date();
        this.description = description;
    }
}
