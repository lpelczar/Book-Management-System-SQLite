package com.codecool.library.services;

import com.codecool.library.dao.BookDAO;
import com.codecool.library.dao.DbBookDAO;
import com.codecool.library.models.Book;
import com.codecool.library.views.BookView;

import java.sql.PreparedStatement;
import java.util.*;

public class BookService {

    private BookDAO dbBookDAO = new DbBookDAO();
    private BookView bookView = new BookView();

    public void addNewBook() {
        double bookISBN = bookView.getBookISBNInput();
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

        double bookISBN = bookView.getBookISBNInput();
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

    public void showAllBooksByGivenAuthor() {
        String author = bookView.getAuthorInput();
        bookView.displayEntries(new ArrayList<>(dbBookDAO.getByAuthor(author)));
    }

    public void showAllBooksSortedByName() {
        List<Book> books = new ArrayList<>(dbBookDAO.getAll());
        books.sort(Comparator.comparing(Book::getTitle));
        List<Object> entries = new ArrayList<>();
        entries.addAll(books);
        bookView.displayEntries(entries);
    }
}
