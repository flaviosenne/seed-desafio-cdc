package com.seed.desafio.cdc.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.util.Date;

@Getter
@Entity
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    public Category(){
    }
    public Category(String name){
        Assert.notNull(name, "Nome da categoria não pode ser nullo");
        this.name = name;
        this.createdAt = new Date();
    }
}
