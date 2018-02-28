package com.codecool.library.dao;

import com.codecool.library.models.Publisher;

import java.util.List;

public interface PublisherDAO {

    Publisher getById(String publisher_id);
    List<Publisher> getAll();
}
