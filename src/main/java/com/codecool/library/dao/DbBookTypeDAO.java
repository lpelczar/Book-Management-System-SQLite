package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.PreparedStatementCreator;
import com.codecool.library.data.contracts.AuthorEntry;
import com.codecool.library.data.contracts.BookTypeEntry;
import com.codecool.library.data.statements.BookTypeStatement;
import com.codecool.library.models.Author;
import com.codecool.library.models.BookType;
import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbBookTypeDAO extends DbHelper implements BookTypeDAO {

    private BookTypeStatement bookTypeStatement = new BookTypeStatement();
    private PreparedStatementCreator psc = new PreparedStatementCreator();

    @Override
    public BookType getById(int id) {
        String sqlStatement = bookTypeStatement.selectBookTypeById();
        BookType bookType = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                bookType = new BookType(
                        resultSet.getInt(BookTypeEntry.type_id.toString()),
                        resultSet.getString(BookTypeEntry.type.toString())
                );
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return bookType;
    }

    @Override
    public List<BookType> getAll() {
        String sqlStatement = bookTypeStatement.selectAllBookTypes();
        PreparedStatement statement = psc.getPreparedStatementBy(new ArrayList<>(),sqlStatement);
        return getBookTypes(statement);
    }

    private List<BookType> getBookTypes(PreparedStatement statement) {
        List<BookType> bookTypes = new ArrayList<>();
        try {
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                bookTypes.add(new BookType(
                        resultSet.getInt(BookTypeEntry.type_id.toString()),
                        resultSet.getString(BookTypeEntry.type.toString())
                ));
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return bookTypes;
    }
}
