package com.seed.desafio.cdc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String email;

    @Column(name = "created_at")
    private Date createdAt;

    private String description;

    public Author(){

    }
    public Author(String name, String email, String description){
        this.name = name;
        this.email = email;
        this.createdAt = new Date();
        this.description = description;
    }
}
