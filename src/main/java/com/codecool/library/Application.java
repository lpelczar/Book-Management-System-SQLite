package com.codecool.library;

import com.codecool.library.controllers.RootController;
import com.codecool.library.dao.*;
import com.codecool.library.services.AuthorService;
import com.codecool.library.services.BookService;
import com.codecool.library.services.BookTypeService;
import com.codecool.library.services.PublisherService;
import com.codecool.library.views.*;

public class Application {

    public static void main(String... args) {

        AuthorDAO authorDAO = new DbAuthorDAO();
        PublisherDAO publisherDAO = new DbPublisherDAO();
        BookTypeDAO bookTypeDAO = new DbBookTypeDAO();
        BookDAO bookDAO = new DbBookDAO(authorDAO, publisherDAO, bookTypeDAO);

        BookView bookView = new BookView();
        AuthorView authorView = new AuthorView();
        PublisherView publisherView = new PublisherView();
        BookTypeView bookTypeView = new BookTypeView();
        RootView rootView = new RootView();

        AuthorService authorService = new AuthorService(authorDAO, authorView);
        PublisherService publisherService = new PublisherService(publisherDAO, publisherView);
        BookTypeService bookTypeService = new BookTypeService(bookTypeDAO, bookTypeView);
        BookService bookService = new BookService(bookDAO, bookView, authorService, publisherService, bookTypeService);

        RootController rootController = new RootController(rootView, bookService);
        rootController.start();
    }
}
