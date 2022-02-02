package com.bookshop.Entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Wishlist {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @ManyToMany private List<Book> books;
    @Transient Map<WishlistProperties, Float> properties;
    
    public void addBook(Book book) {
    	getBooks().add(book);
    	book.addProperties(this);
    }
    
    public void addPropertie(WishlistProperties prop, float value) {
    	getProperties().put(prop, getProperties().get(prop) + value);
    }
    
    public Float getTotalPrice() {
		if (getBooks().isEmpty())
			return 0.0f;
		
		return properties.get(WishlistProperties.PRICE);
	}
    
    public Float getTotalPages() {
    	return properties.get(WishlistProperties.PAGES);
    }
     
    private List<Book> getBooks() {
    	if (books == null)
    		books = new ArrayList<Book>();
    	
    	return books;
    }
    
    private Map<WishlistProperties, Float> getProperties() {
    	if (properties == null) {
    		properties = new HashMap<WishlistProperties, Float>();
    		
    		for (WishlistProperties prop : WishlistProperties.values())
    			properties.put(prop, 0.0f);
    	}
    	
    	return properties;
    }
}