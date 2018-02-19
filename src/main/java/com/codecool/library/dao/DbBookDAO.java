package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.PreparedStatementCreator;
import com.codecool.library.data.contracts.BookEntry;
import com.codecool.library.data.statements.BookStatement;
import com.codecool.library.models.Book;
import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DbBookDAO extends DbHelper implements BookDAO {

    private BookStatement bookStatement = new BookStatement();
    private PreparedStatementCreator psc = new PreparedStatementCreator();

    @Override
    public boolean add(Book book) {
        String sqlStatement = bookStatement.insertBookStatement();
        List<Object> params = Arrays.asList(book.getISBN(), book.getAuthor(), book.getTitle(),
                book.getPublisher(), book.getPublication_year(), book.getPrice(), book.getType());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return update(statement);
    }

    @Override
    public Book getByISBN(double ISBN) {
        String sqlStatement = bookStatement.selectBookByISBN();
        Book book = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setDouble(1, ISBN);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                book = new Book(
                        resultSet.getDouble(BookEntry.ISBN),
                        resultSet.getInt(BookEntry.author),
                        resultSet.getString(BookEntry.title),
                        resultSet.getString(BookEntry.publisher),
                        resultSet.getInt(BookEntry.publication_year),
                        resultSet.getDouble(BookEntry.price),
                        resultSet.getInt(BookEntry.type));
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
        } finally {
            closeConnection();
        }
        return book;
    }

    @Override
    public boolean delete(Book book) {
        String sqlStatement = bookStatement.deleteBookStatement();
        List<Object> params = Collections.singletonList(book.getISBN());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return update(statement);
    }

    @Override
    public List<Book> getAll() {
        String sqlStatement = bookStatement.selectAllBooks();
        PreparedStatement statement = psc.getPreparedStatementBy(new ArrayList<>(),sqlStatement);
        return getBooks(statement);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        String sqlStatement = bookStatement.selectBooksByAuthor();
        List<Object> params = Collections.singletonList(author);
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return getBooks(statement);
    }

    private List<Book> getBooks(PreparedStatement statement) {
        List<Book> books = new ArrayList<>();
        try {
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                books.add(new Book(
                        resultSet.getDouble(BookEntry.ISBN),
                        resultSet.getInt(BookEntry.author),
                        resultSet.getString(BookEntry.title),
                        resultSet.getString(BookEntry.publisher),
                        resultSet.getInt(BookEntry.publication_year),
                        resultSet.getDouble(BookEntry.price),
                        resultSet.getInt(BookEntry.type)));
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
        } finally {
            closeConnection();
        }
        return books;
    }


}
