package com.bookstore;

public class ShowcaseBook extends Book {
    private final String showcaseUrl;

    public ShowcaseBook(String title, String author, String isbn, double price, int yearPublished, String showcaseUrl) {
        super(title, author, isbn, price, yearPublished);
        this.showcaseUrl = showcaseUrl;
    }

    @Override
    public void deliver(String email, String address) {
        String message = "Enjoy the showcase of our book: " + title + "\nAccess it here: " + showcaseUrl;
        // MailService.send(email, message);
    }

    @Override
    public boolean isPurchasable() {
        return false; 
    }

    @Override
    public String toString() {
        return "ShowcaseBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", yearPublished=" + yearPublished +
                '}';
    }

}
