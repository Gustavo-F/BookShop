package com.bookshop.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class User implements Observer{
    
	@Id @Column(unique = true) protected String email;
	protected String password;
        
	@OneToOne protected Wishlist wishlist;
    @ManyToMany protected List<Book> library;
    @Transient protected CalculateUserLibrary calculateUserLibrary;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public abstract String getEmail();

    public abstract String getPassword();
    
    public abstract List<Book> getLibrary();

    public abstract void showLibrary();

    public abstract void addBook(Book book);

    public abstract void removeBook(Book book);

    public abstract double calculatePrices();
    
    public Wishlist getWishlist() {
		if (wishlist == null)
			wishlist = new Wishlist();
		
		return wishlist;
	}
    
    public void setCalculateStrategy(CalculateUserLibrary strategy) {
    	this.calculateUserLibrary = strategy;
    }
}
