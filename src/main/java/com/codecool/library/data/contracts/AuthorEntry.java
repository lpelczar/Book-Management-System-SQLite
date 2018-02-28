package com.codecool.library.data.contracts;

public enum AuthorEntry {

    TABLE_NAME ("authors"),
    author_id ("author_id"),
    name ("name"),
    surname ("surname"),
    birth_year ("birth_year"),
    city ("city"),
    country ("country");

    private final String field_name;

    AuthorEntry(String name) {
        this.field_name = name;
    }

    @Override
    public String toString() {
        return this.field_name;
    }
}
