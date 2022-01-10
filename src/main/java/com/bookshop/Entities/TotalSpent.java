package com.bookshop.Entities;

import java.util.List;

public class TotalSpent implements CalculateUserLibrary {
    @Override
    public double calculateUserLibraryPrices(List<Book> books) {
        double total = 0;

        for (Book book : books)
            total += book.getPrice();

        return total;
    }
}
