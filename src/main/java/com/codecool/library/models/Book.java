package com.codecool.library.models;

public class Book {

    private long ISBN;
    private Author author;
    private String title;
    private Publisher publisher;
    private int publication_year;
    private double price;
    private BookType type;

    public Book(long ISBN, Author author, String title, Publisher publisher,
                int publication_year, double price, BookType type) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publication_year;
    }

    public void setPublicationYear(int publication_year) {
        this.publication_year = publication_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %d, Title: %s, Year: %d, Price: %.2f, \nAuthor: %s, \nPublisher: %s, \nType: %s\n",
                ISBN, title, publication_year, price, author, publisher, type);
    }
}
