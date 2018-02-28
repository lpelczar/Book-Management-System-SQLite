package com.codecool.library.models;

public class Publisher {

    private String publisher_id;
    private String name;
    private String city;
    private String country;

    public Publisher(String publisher_id, String name, String city, String country) {
        this.publisher_id = publisher_id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getPublisherId() {
        return publisher_id;
    }

    public void setPublisherId(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, City: %s, Country: %s",
                publisher_id, name, city, country);
    }
}
