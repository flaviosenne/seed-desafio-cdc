package com.seed.desafio.cdc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Date;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Getter
    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    public Category(){
    }


    public Category(String id, String name, Date createdAt){
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Category(String name){
        Assert.notNull(name, "Nome da categoria não pode ser nullo");
        this.name = name;
        this.createdAt = new Date();
    }

    public Category withId(String id){
        this.id = id;
        return this;
    }
}
