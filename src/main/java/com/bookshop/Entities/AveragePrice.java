package com.bookshop.Entities;

import java.util.List;

public class AveragePrice implements CalculateUserLibrary {
    @Override
    public double calculateUserLibraryPrices(List<Book> books) {
        double average = 0;

        for (Book book : books) {
            average += book.getPrice();
        }

        average = average / books.size();
        return average;
    }
}
