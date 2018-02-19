package com.codecool.library.services;

import com.codecool.library.dao.BookDAO;
import com.codecool.library.dao.DbBookDAO;
import com.codecool.library.models.Book;
import com.codecool.library.views.BookView;

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
            int price = bookView.getBookPriceInput();
            int type = bookView.getBookTypeInput();
            if (dbBookDAO.add(new Book(bookISBN, author, title, publisher, year, price, type))) {
                bookView.displayQuestSuccessfullyAdded();
            } else {
                bookView.displayErrorAddingQuest();
            }
        }
    }
}