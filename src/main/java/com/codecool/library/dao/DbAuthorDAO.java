package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.contracts.AuthorEntry;
import com.codecool.library.data.statements.AuthorStatement;
import com.codecool.library.models.Author;
import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAuthorDAO extends DbHelper implements AuthorDAO {

    private AuthorStatement authorStatement = new AuthorStatement();

    @Override
    public Author getById(int author_id) {
        String sqlStatement = authorStatement.selectAuthorById();
        Author author = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setInt(1, author_id);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                author = new Author(
                        resultSet.getInt(AuthorEntry.author_id.toString()),
                        resultSet.getString(AuthorEntry.name.toString()),
                        resultSet.getString(AuthorEntry.surname.toString()),
                        resultSet.getInt(AuthorEntry.birth_year.toString()),
                        resultSet.getString(AuthorEntry.city.toString()),
                        resultSet.getString(AuthorEntry.country.toString())
                        );
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return author;
    }
}
