package com.codecool.library.models;

public class Publisher {

    private String publisher_id;
    private String name;
    private String text;
    private String country;

    public Publisher(String publisher_id, String name, String text, String country) {
        this.publisher_id = publisher_id;
        this.name = name;
        this.text = text;
        this.country = country;
    }

    public String getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
