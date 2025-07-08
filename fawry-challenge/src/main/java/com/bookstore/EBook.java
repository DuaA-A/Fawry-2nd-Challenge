package com.bookstore;

public class EBook extends Book{
    private final String fileType;
    
    public EBook(String title, String author, String isbn, double price, int yearPublished, String fileType) {
        super(title, author, isbn, price, yearPublished);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public void deliver(String email, String address) {
        // MailService.send(email, "enjoy your eBook: " + title + " in " + fileType + " format."); 
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }
}
