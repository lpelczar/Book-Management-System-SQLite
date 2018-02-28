package com.codecool.library.dao;

import com.codecool.library.models.Author;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAll();
    Author getById(int author_id);
}
