package com.codecool.library.data.contracts;

public enum BookTypeEntry {

    TABLE_NAME ("type_books"),
    type_id ("type_id"),
    type ("type");

    private final String field_name;

    BookTypeEntry(String name) {
        this.field_name = name;
    }

    @Override
    public String toString() {
        return this.field_name;
    }
}
