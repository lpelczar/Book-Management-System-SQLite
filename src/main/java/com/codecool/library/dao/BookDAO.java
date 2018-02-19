package com.codecool.library.dao;

import com.codecool.library.models.Book;

public interface BookDAO {
    boolean add(Book book);
    Book getByISBN(int ISBN);
}
