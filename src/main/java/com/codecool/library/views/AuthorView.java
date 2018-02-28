package com.codecool.library.views;

import com.codecool.library.models.Author;
import com.codecool.library.utils.InputGetter;

import java.time.LocalDate;

public class AuthorView extends AbstractView {


    public int getAuthorIdInput() {
        return InputGetter.getIntInputFromConsole("Enter author ID: ");
    }

    public void displayFullNameAndAge(Author author) {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - author.getBirth_year();
        System.out.println("Full name: " + author.getName() + " " + author.getSurname() + " Age: " + age);
        displayPressAnyKeyToContinueMessage();
    }
}
