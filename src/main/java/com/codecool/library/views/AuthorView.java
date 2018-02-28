package com.codecool.library.views;

import com.codecool.library.utils.InputGetter;

public class AuthorView extends AbstractView {


    public int getAuthorIdInput() {
        return InputGetter.getIntInputFromConsole("Enter author ID: ");
    }
}
