package com.bookstore;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String title, String author, String isbn, double price, int yearPublished, int stock) {
        super(title, author, isbn, price, yearPublished);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
    public void reduceStock(int quantity) {
        if (stock < quantity) throw new IllegalArgumentException("not enough stock;");
        stock -= quantity;
    }

    @Override
    public void deliver(String email, String address) {
        System.out.println("quantum book store: shipping paper book to " + address);
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }
}
