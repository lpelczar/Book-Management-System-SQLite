package com.codecool.library.data.contracts;

public enum BookEntry {
    TABLE_NAME ("books"),
    ISBN ("ISBN"),
    author ("author"),
    title ("title"),
    publisher ("publisher"),
    publication_year ("publication_year"),
    price ("price"),
    type ("type");

    private final String name;

    BookEntry(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
