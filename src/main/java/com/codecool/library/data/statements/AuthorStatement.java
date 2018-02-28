package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.AuthorEntry;

public class AuthorStatement {

    public String selectAuthorById() {
        return "SELECT * FROM " + AuthorEntry.TABLE_NAME +
                " WHERE " + AuthorEntry.author_id + " = ?;" ;
    }

    public String selectAllAuthors() {
        return "SELECT * FROM " + AuthorEntry.TABLE_NAME + ";" ;
    }
}
