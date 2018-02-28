package com.codecool.library.views;

import com.codecool.library.utils.InputGetter;

public class BookTypeView extends AbstractView {


    public int getBookTypeIdInput() {
        return InputGetter.getIntInputFromConsole("Enter book type ID: ");
    }
}
