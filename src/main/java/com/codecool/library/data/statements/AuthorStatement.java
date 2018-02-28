package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.BookEntry;

public class AuthorStatement {

    public String selectAuthorById() {
        return "SELECT * FROM " + BookEntry.TABLE_NAME +
                " WHERE " + BookEntry.ISBN + " = ?;" ;
    }
}
