package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.PreparedStatementCreator;
import com.codecool.library.data.contracts.BookEntry;
import com.codecool.library.data.statements.BookStatement;
import com.codecool.library.models.Author;
import com.codecool.library.models.Book;
import com.codecool.library.models.Publisher;
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
    private AuthorDAO authorDAO;
    private PublisherDAO publisherDAO;
    private BookTypeDAO bookTypeDAO;

    public DbBookDAO(AuthorDAO authorDAO, PublisherDAO publisherDAO, BookTypeDAO bookTypeDAO) {
        this.authorDAO = authorDAO;
        this.publisherDAO = publisherDAO;
        this.bookTypeDAO = bookTypeDAO;
    }

    @Override
    public boolean add(Book book) {
        String sqlStatement = bookStatement.insertBookStatement();
        List params = Arrays.asList(book.getISBN(), book.getAuthor().getId(), book.getTitle(),
                book.getPublisher().getPublisher_id(), book.getPublication_year(),
                book.getPrice(), book.getType().getType_id());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return update(statement);
    }

    @Override
    public boolean delete(Book book) {
        String sqlStatement = bookStatement.deleteBookStatement();
        List params = Collections.singletonList(book.getISBN());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return update(statement);
    }

    @Override
    public boolean update(Book book) {
        String sqlStatement = bookStatement.updateBookStatement();
        List params = Arrays.asList(book.getAuthor().getId(), book.getTitle(),
                book.getPublisher().getPublisher_id(), book.getPublication_year(),
                book.getPrice(), book.getType().getType_id(), book.getISBN());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return update(statement);
    }

    @Override
    public Book getByISBN(long ISBN) {
        String sqlStatement = bookStatement.selectBookByISBN();
        Book book = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setDouble(1, ISBN);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                book = new Book(
                        resultSet.getLong(BookEntry.ISBN.toString()),
                        authorDAO.getById(resultSet.getInt(BookEntry.author.toString())),
                        resultSet.getString(BookEntry.title.toString()),
                        publisherDAO.getById(resultSet.getString(BookEntry.publisher.toString())),
                        resultSet.getInt(BookEntry.publication_year.toString()),
                        resultSet.getDouble(BookEntry.price.toString()),
                        bookTypeDAO.getById(resultSet.getInt(BookEntry.type.toString()))
                );
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        String sqlStatement = bookStatement.selectAllBooks();
        PreparedStatement statement = psc.getPreparedStatementBy(new ArrayList<>(),sqlStatement);
        return getBooks(statement);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        String sqlStatement = bookStatement.selectBooksByAuthor();
        List params = Collections.singletonList(author.getId());
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return getBooks(statement);
    }

    @Override
    public List<Book> getBySearchPhrase(String searchPhrase) {
        String sqlStatement = bookStatement.selectBooksBySearchPhrase();
        List params = new ArrayList<>(Collections.nCopies(5, "%" + searchPhrase + "%"));
        PreparedStatement statement = psc.getPreparedStatementBy(params, sqlStatement);
        return getBooks(statement);
    }

    private List<Book> getBooks(PreparedStatement statement) {
        List<Book> books = new ArrayList<>();
        try {
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                books.add(new Book(
                        resultSet.getLong(BookEntry.ISBN.toString()),
                        authorDAO.getById(resultSet.getInt(BookEntry.author.toString())),
                        resultSet.getString(BookEntry.title.toString()),
                        publisherDAO.getById(resultSet.getString(BookEntry.publisher.toString())),
                        resultSet.getInt(BookEntry.publication_year.toString()),
                        resultSet.getDouble(BookEntry.price.toString()),
                        bookTypeDAO.getById(resultSet.getInt(BookEntry.type.toString()))
                ));
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return books;
    }


}
