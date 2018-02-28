package com.codecool.library.services;

import com.codecool.library.dao.PublisherDAO;
import com.codecool.library.models.Publisher;
import com.codecool.library.views.PublisherView;

import java.util.ArrayList;

public class PublisherService {

    private PublisherDAO publisherDAO;
    private PublisherView publisherView;

    public PublisherService(PublisherDAO publisherDAO, PublisherView publisherView) {
        this.publisherDAO = publisherDAO;
        this.publisherView = publisherView;
    }


    public Publisher getPublisher() {
        publisherView.displayEntriesNoInput(new ArrayList<>(publisherDAO.getAll()));
        String id;
        do {
            id = publisherView.getPublisherIdInput();
        } while (publisherDAO.getById(id) == null);
        return publisherDAO.getById(id);
    }
}
