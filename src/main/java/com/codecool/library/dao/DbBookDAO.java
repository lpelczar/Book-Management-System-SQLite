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
import java.util.Arrays;
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
    public Book getByISBN(int ISBN) {
        String sqlStatement = bookStatement.selectBookByISBN();
        Book book = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setInt(1, ISBN);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                book = new Book(
                        resultSet.getInt(BookEntry.ISBN),
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
}
