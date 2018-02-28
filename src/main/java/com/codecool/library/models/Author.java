package com.codecool.library.models;

public class Author {

    private int id;
    private String name;
    private String surname;
    private int birth_year;
    private String city;
    private String country;

    public Author(int id, String name, String surname, int birth_year, String city, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth_year = birth_year;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(int birth_year) {
        this.birth_year = birth_year;
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
        return String.format("ID: %d, Name: %s, Surname: %s, Birth: %d, City: %s, Country: %s",
                id, name, surname, birth_year, city, country);
    }
}
