package com.codecool.library.controllers;

import com.codecool.library.services.BookService;
import com.codecool.library.views.RootView;

public class RootController {

    private RootView rootView;
    private BookService bookService;

    public RootController(RootView rootView, BookService bookService) {
        this.rootView = rootView;
        this.bookService = bookService;
    }

    public void start() {
        boolean isAppRunning = true;

        while (isAppRunning) {
            rootView.displayMenu();
            String userInput = rootView.getUserInput();
            switch (userInput) {
                case "1":
                    bookService.addNewBook();
                    break;
                case "2":
                    bookService.editBook();
                    break;
                case "3":
                    bookService.deleteBook();
                    break;
                case "4":
                    bookService.searchBook();
                    break;
                case "5":
                    bookService.showAllBooksSortedByName();
                    break;
                case "6":
                    bookService.showAllBooksByGivenAuthor();
                    break;
                case "7":
                    bookService.showHowManyBooksEachAuthorHasCreated();
                case "0":
                    isAppRunning = false;
                    break;
                default:
                    rootView.displayWrongInputMessage();
            }
        }
    }
}
