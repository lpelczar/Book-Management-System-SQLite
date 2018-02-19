package com.codecool.library.services;

import com.codecool.library.dao.BookDAO;
import com.codecool.library.dao.DbBookDAO;
import com.codecool.library.models.Book;
import com.codecool.library.views.BookView;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {

    private BookDAO dbBookDAO = new DbBookDAO();
    private BookView bookView = new BookView();

    public void addNewBook() {
        int bookISBN = bookView.getBookISBNInput();
        if (dbBookDAO.getByISBN(bookISBN) != null) {
            bookView.displayBookAlreadyExists();
        } else {
            int author = bookView.getBookAuthorInput();
            String title = bookView.getBookTitleInput();
            String publisher = bookView.getBookPublisherInput();
            int year = bookView.getBookPublicationYearInput();
            double price = bookView.getBookPriceInput();
            int type = bookView.getBookTypeInput();
            if (dbBookDAO.add(new Book(bookISBN, author, title, publisher, year, price, type))) {
                bookView.displayBookSuccessfullyAdded();
            } else {
                bookView.displayErrorAddingBook();
            }
        }
    }

    public void deleteBook() {

        bookView.displayEntriesNoInput(new ArrayList<>(dbBookDAO.getAll()));
        if (dbBookDAO.getAll().isEmpty()) {
            bookView.displayPressAnyKeyToContinueMessage();
            return;
        }

        int bookISBN = bookView.getBookISBNInput();
        if (dbBookDAO.getByISBN(bookISBN) != null) {
            if (dbBookDAO.delete(dbBookDAO.getByISBN(bookISBN))) {
                bookView.displayBookDeletedMessage();
            } else {
                bookView.displayDeleteErrorMessage();
            }
        } else {
            bookView.displayThereIsNoBookMessage();
        }
    }
}
