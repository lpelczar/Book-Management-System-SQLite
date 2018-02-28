package com.codecool.library.services;

import com.codecool.library.dao.AuthorDAO;
import com.codecool.library.models.Author;
import com.codecool.library.views.AuthorView;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private AuthorDAO authorDAO;
    private AuthorView authorView;

    public AuthorService(AuthorDAO authorDAO, AuthorView authorView) {
        this.authorDAO = authorDAO;
        this.authorView = authorView;
    }

    public Author getAuthor() {
        authorView.displayEntriesNoInput(new ArrayList<>(authorDAO.getAll()));
        int id;
        do {
            id = authorView.getAuthorIdInput();
        } while (authorDAO.getById(id) == null);
        return authorDAO.getById(id);
    }

    public List<Author> getAllAuthors() {
        return authorDAO.getAll();
    }
}
