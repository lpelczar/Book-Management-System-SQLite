package com.codecool.library.views;

import com.codecool.library.models.Book;
import com.codecool.library.utils.InputGetter;

public class BookView extends AbstractView {


    public long getBookISBNInput() {
        return InputGetter.getLongInputFromConsole("Enter book ISBN: ");
    }

    public void displayBookAlreadyExists() {
        System.out.println("Book with this name already exists!");
        displayPressAnyKeyToContinueMessage();
    }

    public String getBookTitleInput() {
        return InputGetter.getStringInputFromConsole("Enter title: ");
    }

    public int getBookPublicationYearInput() {
        return InputGetter.getIntInputFromConsole("Enter publication year: ");
    }

    public double getBookPriceInput() {
        return InputGetter.getDoubleInputFromConsole("Enter price: ");
    }

    public void displayBookSuccessfullyAdded() {
        System.out.println("Book successfully added!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayErrorAddingBook() {
        System.out.println("Error adding book!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayBookDeletedMessage() {
        System.out.println("Book successfully deleted!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayDeleteErrorMessage() {
        System.out.println("Error deleting book!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayThereIsNoBookMessage() {
        System.out.println("There is no book with this ISBN number!");
        displayPressAnyKeyToContinueMessage();
    }

    public String getAuthorInput() {
        return InputGetter.getStringInputFromConsole("Enter author: ");
    }

    public String getValueToUpdate(Book book) {
        System.out.println("\n" + book);
        System.out.println("\nWhat would you like to change:" +
                "\n1. Author" +
                "\n2. Title" +
                "\n3. Publisher" +
                "\n4. Publication year" +
                "\n5. Price" +
                "\n6. Type");
        return InputGetter.getStringInputFromConsole("Enter option: ");
    }

    public int askForNewAuthor() {
        return InputGetter.getIntInputFromConsole("Enter new author ID: ");
    }

    public String askForTitleInput() {
        return InputGetter.getStringInputFromConsole("Enter new title: ");
    }

    public String askForPublisherInput() {
        return InputGetter.getStringInputFromConsole("Enter new publisher: ");
    }

    public void displayWrongOptionMessage() {
        System.out.println("Display wrong option message!");
        displayPressAnyKeyToContinueMessage();
    }

    public int askForYearInput() {
        return InputGetter.getIntInputFromConsole("Enter new publication year: ");
    }

    public double askForPriceInput() {
        return InputGetter.getDoubleInputFromConsole("Enter new price: ");
    }

    public int askForTypeInput() {
        return InputGetter.getIntInputFromConsole("Enter new type: ");
    }

    public String getSearchPhrase() {
        return InputGetter.getStringInputFromConsole("Enter search phrase: ");
    }
}
