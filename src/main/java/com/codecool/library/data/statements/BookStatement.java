package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.AuthorEntry;
import com.codecool.library.data.contracts.BookEntry;
import com.codecool.library.data.contracts.BookTypeEntry;
import com.codecool.library.data.contracts.PublisherEntry;

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
                " WHERE " + BookEntry.author + " = ?;" ;
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

    public String selectBooksBySearchPhrase() {
        return "SELECT * FROM " + BookEntry.TABLE_NAME +
                " JOIN " + AuthorEntry.TABLE_NAME + " ON " +
                BookEntry.TABLE_NAME + "." + BookEntry.author + " = " +
                AuthorEntry.TABLE_NAME + "." + AuthorEntry.author_id +
                " JOIN " + PublisherEntry.TABLE_NAME + " ON " +
                BookEntry.TABLE_NAME + "." + BookEntry.publisher + " = " +
                PublisherEntry.TABLE_NAME + "." + PublisherEntry.publisher_id +
                " JOIN " + BookTypeEntry.TABLE_NAME + " ON " +
                BookEntry.TABLE_NAME + "." + BookEntry.type + " = " +
                BookTypeEntry.TABLE_NAME + "." + BookTypeEntry.type_id +
                " WHERE " +
                BookEntry.ISBN + " LIKE ? OR " +
                BookEntry.title + " LIKE ? OR " +
                AuthorEntry.TABLE_NAME + "." + AuthorEntry.name + " LIKE ? OR " +
                BookEntry.publication_year + " LIKE ? OR " +
                PublisherEntry.TABLE_NAME + "." + PublisherEntry.name + " LIKE ? " +
                ";" ;
    }
}
