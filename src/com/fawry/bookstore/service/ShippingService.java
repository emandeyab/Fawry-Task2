package com.fawry.bookstore.service;

import com.fawry.bookstore.Books.Book;

public class ShippingService {
    public static void ship(Book book, String address) {
        System.out.println("Shipping " + book.getTitle() + " to " + address);
    }
}