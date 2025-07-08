package com.fawry.bookstore.service;

import com.fawry.bookstore.Books.Book;

public class MailService {
    public static void sendEmail(Book book, String email) {
        System.out.println("Sending " + book.getTitle() + " to " + email);
    }
}