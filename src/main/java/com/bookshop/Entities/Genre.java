package com.bookshop.Entities;

import io.jsondb.annotation.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document(collection = "genres", schemaVersion = "1.0")
@Entity
public class Genre {
    @Id // Hibernate
    @io.jsondb.annotation.Id // JsonDB
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
