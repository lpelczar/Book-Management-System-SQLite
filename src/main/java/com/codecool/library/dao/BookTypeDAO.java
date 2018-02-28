package com.codecool.library.dao;

import com.codecool.library.models.BookType;

import java.util.List;

public interface BookTypeDAO {

    BookType getById(int id);
    List<BookType> getAll();
}
