package com.bookstore;

public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected int yearPublished;
    
    public Book(String title, String author, String isbn, double price, int yearPublished) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.yearPublished = yearPublished;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public double getPrice() {
        return price;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public abstract void deliver(String mail, String address);
    public abstract boolean isPurchasable();

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", yearPublished=" + yearPublished +
                '}';
    };
}
