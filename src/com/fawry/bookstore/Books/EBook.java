package com.fawry.bookstore.Books;

import com.fawry.bookstore.interfaces.Buyable;
import com.fawry.bookstore.service.MailService;

public class EBook extends Book implements Buyable {
    private String fileType;

    public EBook(String isbn, String title, int publicationYear, double price, String fileType) {
        super(isbn, title, publicationYear, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType){
        this.fileType = fileType;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        MailService.sendEmail(this, email);
        //System.out.println("You have purchased the Ebook: " + getTitle());
        return price * quantity;
    }

}