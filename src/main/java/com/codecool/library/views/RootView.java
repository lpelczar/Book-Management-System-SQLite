package com.codecool.library.views;

import com.codecool.library.utils.InputGetter;

public class RootView extends AbstractView {

    public void displayMenu() {

        clearConsole();
        System.out.println("\nWhat do you want to do?\n" +
                " 1. Add new book\n" +
                " 2. Edit book\n" +
                " 3. Delete book\n" +
                " 4. Search for book\n" +
                " 5. Show all books sorted by name ascending\n" +
                " 6. Show all books by given author\n" +
                " 0. Exit");
    }

    public void displayWrongInputMessage() {
        System.out.println("Wrong input!");
    }

    public String getUserInput() {
        return InputGetter.getStringInputFromConsole("Choose option: ");
    }
}
