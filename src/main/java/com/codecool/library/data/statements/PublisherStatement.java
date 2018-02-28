package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.PublisherEntry;

public class PublisherStatement {

    public String selectPublisherById() {
        return "SELECT * FROM " + PublisherEntry.TABLE_NAME +
                " WHERE " + PublisherEntry.publisher_id + " = ?;" ;
    }
}
