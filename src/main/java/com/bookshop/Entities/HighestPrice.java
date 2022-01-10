package com.bookshop.Entities;

import java.util.List;

public class HighestPrice implements CalculateUserLibrary {
    @Override
    public double calculateUserLibraryPrices(List<Book> books) {
        double highestPrice = 0;

        for (Book book : books) {
            if (book.getPrice() > highestPrice)
                highestPrice = book.getPrice();
        }

        return highestPrice;
    }
}
