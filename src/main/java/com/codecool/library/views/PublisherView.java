package com.codecool.library.views;

import com.codecool.library.utils.InputGetter;

public class PublisherView extends AbstractView {

    public String getPublisherIdInput() {
        return InputGetter.getStringInputFromConsole("Enter publisher ID: ");
    }
}
