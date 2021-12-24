package com.bookshop.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {
    @Id private String name;

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
