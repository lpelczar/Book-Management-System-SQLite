package com.codecool.library.services;

import com.codecool.library.dao.BookTypeDAO;
import com.codecool.library.models.BookType;
import com.codecool.library.views.BookTypeView;

import java.util.ArrayList;

public class BookTypeService {

    private BookTypeDAO bookTypeDAO;
    private BookTypeView bookTypeView;

    public BookTypeService(BookTypeDAO bookTypeDAO, BookTypeView bookTypeView) {
        this.bookTypeDAO = bookTypeDAO;
        this.bookTypeView = bookTypeView;
    }

    public BookType getBookType() {
        bookTypeView.displayEntriesNoInput(new ArrayList<>(bookTypeDAO.getAll()));
        int id;
        do {
            id = bookTypeView.getBookTypeIdInput();
        } while (bookTypeDAO.getById(id) == null);
        return bookTypeDAO.getById(id);
    }
}
