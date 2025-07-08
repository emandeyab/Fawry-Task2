package com.fawry.bookstore.Books;

import com.fawry.bookstore.interfaces.Buyable;
import com.fawry.bookstore.service.ShippingService;

public class PaperBook extends Book implements Buyable {
    private int stock;

    public PaperBook(String isbn, String title, int publicationYear, double price, int stock){
        super(isbn, title, publicationYear, price);
        this.stock = stock;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (stock < quantity) {
            throw new IllegalStateException("The requested quantity exceeds the available stock for this book: " + title);
        }
        stock -= quantity;
        ShippingService.ship(this, address);
        //System.out.println("You have purchased the paper book: " + getTitle());
        return price * quantity;
    }


}
