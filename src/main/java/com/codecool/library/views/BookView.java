package com.codecool.library.views;

import com.codecool.library.utils.InputGetter;

public class BookView extends AbstractView {


    public int getBookISBNInput() {
        return InputGetter.getIntInputFromConsole("Enter book ISBN: ");
    }

    public void displayBookAlreadyExists() {
        System.out.println("Book with this name already exists!");
        displayPressAnyKeyToContinueMessage();
    }

    public int getBookAuthorInput() {
        return InputGetter.getIntInputFromConsole("Enter author: ");
    }


    public String getBookTitleInput() {
        return InputGetter.getStringInputFromConsole("Enter title: ");
    }


    public String getBookPublisherInput() {
        return InputGetter.getStringInputFromConsole("Enter publisher: ");
    }


    public int getBookPublicationYearInput() {
        return InputGetter.getIntInputFromConsole("Enter publication year: ");
    }

    public double getBookPriceInput() {
        return InputGetter.getIntInputFromConsole("Enter price: ");
    }

    public int getBookTypeInput() {
        return InputGetter.getIntInputFromConsole("Enter book type: ");
    }

    public void displayBookSuccessfullyAdded() {
        System.out.println("Book successfully added!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayErrorAddingBook() {
        System.out.println("Error adding book!");
        displayPressAnyKeyToContinueMessage();
    }
}
