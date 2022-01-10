package com.bookshop.Entities;

import java.util.List;

public class LowestPrice implements CalculateUserLibrary {
    @Override
    public double calculateUserLibraryPrices(List<Book> books) {
        double lowestPrice = 0;
        int index = 1;

        lowestPrice = books.get(0).getPrice();

        do {
            if (books.get(index).getPrice() < lowestPrice)
                lowestPrice = books.get(index).getPrice();

            index++;
        } while (index <= books.size());

        return lowestPrice;
    }
}
