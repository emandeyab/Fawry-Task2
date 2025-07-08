package com.fawry.bookstore.service;

import com.fawry.bookstore.Books.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("This book has been added successfully: " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int currentYear, int yearsThreshold) {
        List<Book> removedBooks = new ArrayList<>();
        List<String> isbnsToRemove = new ArrayList<>();

        for (Book book : books.values()) {
            if (currentYear - book.getPublicationYear() > yearsThreshold) {
                removedBooks.add(book);
                isbnsToRemove.add(book.getIsbn());
            }
        }

        for (String isbn : isbnsToRemove) {
            books.remove(isbn);
            System.out.println("Removed outdated book with ISBN: " + isbn);
        }

        return removedBooks;
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }
}