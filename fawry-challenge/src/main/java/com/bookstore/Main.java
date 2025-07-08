package com.bookstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final Map<String, Book> inventory = new HashMap<>();

    public static void main(String[] args) {
        Main app = new Main();  

        app.addBook(new PaperBook("Java Basics", "Alice", "111", 100.0, 2015, 10));
        app.addBook(new EBook("Advanced Java", "Bob", "222", 70.0, 2019, "pdf"));
        app.addBook(new ShowcaseBook("Future Java", "Carol", "333", 50.0, 2010, "https://showcase.com/futurejava"));

        app.removeOutdatedBooks(10);

        app.buyBook("111", 2, "user1@example.com", "123 Main St");
        app.buyBook("222", 1, "user2@example.com", "N/A");

        try {
            app.buyBook("333", 1, "user3@example.com", "N/A");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        try {
            app.buyBook("111", 20, "user4@example.com", "456 Another St");
        } catch (IllegalArgumentException e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }

    public void removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<String> toRemove = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (currentYear - book.getYearPublished() > maxAge) {
                toRemove.add(book.getIsbn());
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }
        toRemove.forEach(inventory::remove);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
        }
        if (!book.isPurchasable()) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " is not for sale.");
        }

        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            paperBook.reduceStock(quantity);
        }

        double totalPrice = quantity * book.getPrice();
        book.deliver(email, address);

        System.out.println("Quantum book store: Purchase complete for ISBN " + isbn + ", quantity " + quantity + ", amount paid: " + totalPrice);
        return totalPrice;
    }
}