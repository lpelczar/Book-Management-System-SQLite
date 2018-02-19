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

    public String deleteBookStatement() {
        return "DELETE FROM " + BookEntry.TABLE_NAME +
                " WHERE " + BookEntry.ISBN + " = ?;" ;
    }

    public String selectAllBooks() {
        return "SELECT * FROM " + BookEntry.TABLE_NAME + ";" ;
    }

    public String selectBooksByAuthor() {
        return "SELECT * FROM " + BookEntry.TABLE_NAME +
                " JOIN authors ON " +
                BookEntry.TABLE_NAME + "." + BookEntry.author + " = authors.author_id WHERE authors.name = ?;" ;
    }

    public String updateBookStatement() {
        return "UPDATE " + BookEntry.TABLE_NAME + " SET " +
                BookEntry.author + " = ?," +
                BookEntry.title + " = ?," +
                BookEntry.publisher + " = ?," +
                BookEntry.publication_year + " = ?," +
                BookEntry.price + " = ?," +
                BookEntry.type + " = ? WHERE " + BookEntry.ISBN + " = ?;";
    }

    public String selectBooksBySearchPhrase(String searchPhrase) {
        return "SELECT * FROM " + BookEntry.TABLE_NAME +
                " WHERE " +
                BookEntry.ISBN + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.author + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.title + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.publisher + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.publication_year + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.price + " LIKE '%" + searchPhrase + "%' OR " +
                BookEntry.type + " LIKE '%" + searchPhrase + "%' " +
                ";" ;
    }
}
