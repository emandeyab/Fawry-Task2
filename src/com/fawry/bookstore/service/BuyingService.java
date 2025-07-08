package com.fawry.bookstore.service;

import com.fawry.bookstore.interfaces.Buyable;
import com.fawry.bookstore.Books.Book;

public class BuyingService {
    private Inventory inventory;

    public BuyingService() {
        this.inventory = new Inventory();
    }

    public void addBook(Book book) {
        inventory.addBook(book);
    }

    public void removeOutdatedBooks(int currentYear, int yearsThreshold) {
        inventory.removeOutdatedBooks(currentYear, yearsThreshold);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBookByIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }
        if (!(book instanceof Buyable)) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not available for purchase because it is a ShowCase Book");
        }
        double total = ((Buyable) book).buy(quantity, email, address);
        System.out.println("Purchased " + quantity + " of " + book.getTitle() + " for $" + total);
        return total;
    }
}