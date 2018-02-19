package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.BookEntry;

public class BookStatement {

    public String insertBookStatement() {
        return "INSERT INTO " + BookEntry.TABLE_NAME + " (" +
                BookEntry.ISBN + "," +
                BookEntry.author + "," +
                BookEntry.title + "," +
                BookEntry.publisher + "," +
                BookEntry.publication_year + "," +
                BookEntry.price + "," +
                BookEntry.type + ")" +
                " VALUES (?,?,?,?,?,?,?);" ;
    }

    public String selectBookByISBN() {
        return "SELECT * FROM " + BookEntry.TABLE_NAME +
                " WHERE " + BookEntry.ISBN + " = ?;" ;
    }
}
