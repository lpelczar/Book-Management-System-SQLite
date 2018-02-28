package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.contracts.BookTypeEntry;
import com.codecool.library.data.statements.BookTypeStatement;
import com.codecool.library.models.BookType;
import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbBookTypeDAO extends DbHelper implements BookTypeDAO {

    private BookTypeStatement bookTypeStatement = new BookTypeStatement();

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
}
