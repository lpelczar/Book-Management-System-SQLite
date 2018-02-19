package com.codecool.library.dao;

import com.codecool.library.models.Book;

import java.util.List;

public interface BookDAO {
    boolean add(Book book);
    boolean delete(Book book);
    List<Book> getAll();
    List<Book> getByAuthor(String author);
    Book getByISBN(int ISBN);
}
