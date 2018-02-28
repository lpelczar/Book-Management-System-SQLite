package com.codecool.library.data.contracts;

public enum PublisherEntry {

    TABLE_NAME ("publishers"),
    publisher_id ("publisher_id"),
    name ("name"),
    city ("city"),
    country ("country");

    private final String field_name;

    PublisherEntry(String name) {
        this.field_name = name;
    }

    @Override
    public String toString() {
        return this.field_name;
    }
}
