package com.codecool.library.models;

public class Book {

    private double ISBN;
    private int author;
    private String title;
    private String publisher;
    private int publication_year;
    private double price;
    private int type;

    public Book(double ISBN, int author, String title, String publisher, int publication_year, double price, int type) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }

    public double getISBN() {
        return ISBN;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %.0f, Author: %d, Title: %s, Publisher: %s, Year: %d, Price: %.2f, Type: %d",
                ISBN, author, title, publisher, publication_year, price, type);
    }
}
