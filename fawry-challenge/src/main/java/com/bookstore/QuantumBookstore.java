package com.bookstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QuantumBookstore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            if (currentYear - book.getYearPublished() > maxAge) {
                removed.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }
        return removed;
    }
    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null || !book.isPurchasable()) throw new IllegalArgumentException("Book not available for purchase");

        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            pb.reduceStock(quantity);
        }

        double amount = quantity * book.getPrice();
        book.deliver(email, address);
        System.out.println("quantum book store:purchase complete.n/amount paid: " + amount);
        return amount;
    }
}
