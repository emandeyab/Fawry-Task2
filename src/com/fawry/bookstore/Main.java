package com.fawry.bookstore;
import com.fawry.bookstore.Books.EBook;
import com.fawry.bookstore.Books.PaperBook;
import com.fawry.bookstore.Books.ShowcaseBook;
import com.fawry.bookstore.service.BuyingService;


public class Main {
    public static void main(String[] args) {
        BuyingService bookstore = new BuyingService();

        // Test adding books
        System.out.println("=== Adding Books ===");
        bookstore.addBook(new PaperBook("A1", "Java Programming",  2020, 29.99, 10));
        bookstore.addBook(new EBook("A2", "Python",  2021, 19.99, "PDF"));
        bookstore.addBook(new ShowcaseBook("A3", "AI", 2022, 0.00));
        bookstore.addBook(new PaperBook("A4", "Html",  2015, 15.99, 5));

        // Test buying books
        System.out.println("\n=== Buying Books ===");
        try {
            System.out.println("========================");
            System.out.println("{  Success Process  }");
            double total = bookstore.buyBook("A1", 2, "emoo@gmail.com", "Sadat City, Menofia");
            System.out.println("Total paid: $" + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("========================");
            System.out.println("{  Success Process  }");
            double total = bookstore.buyBook("A2", 1, "yazan@gmail.com", null);
            System.out.println("Total paid: $" + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test buying showcase book
        try {
            System.out.println("========================");
            System.out.println("{  Test buying showcase book  }");
            bookstore.buyBook("A3", 1, "alaa@example.com", "Cairo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test buying more than stock
        try {
            System.out.println("========================");
            System.out.println("{  Test buying more than stock  }");
            bookstore.buyBook("A1", 11, "belal@gmail.com", "Shebin Elkom");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test removing outdated books
        System.out.println("========================");
        System.out.println("\n=== Removing Outdated Books ===");
        bookstore.removeOutdatedBooks(2025, 5);
    }
}