package com.codecool.library;

import com.codecool.library.controllers.RootController;
import com.codecool.library.dao.DbBookDAO;
import com.codecool.library.services.BookService;
import com.codecool.library.views.BookView;
import com.codecool.library.views.RootView;

public class Application {

    public static void main(String... args) {

        BookService bookService = new BookService(new DbBookDAO(), new BookView());
        RootController rootController = new RootController(new RootView(), bookService);
        rootController.start();
    }
}
