package com.codecool.library.dao;

import com.codecool.library.data.DbHelper;
import com.codecool.library.data.contracts.PublisherEntry;
import com.codecool.library.data.statements.PublisherStatement;
import com.codecool.library.models.Publisher;
import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbPublisherDAO extends DbHelper implements PublisherDAO {

    private PublisherStatement publisherStatement = new PublisherStatement();

    @Override
    public Publisher getById(String publisher_id) {
        String sqlStatement = publisherStatement.selectPublisherById();
        Publisher publisher = null;
        try {
            PreparedStatement statement = getPreparedStatement(sqlStatement);
            statement.setString(1, publisher_id);
            ResultSet resultSet = query(statement);
            while (resultSet.next())
                publisher = new Publisher(
                        resultSet.getString(PublisherEntry.publisher_id.toString()),
                        resultSet.getString(PublisherEntry.name.toString()),
                        resultSet.getString(PublisherEntry.city.toString()),
                        resultSet.getString(PublisherEntry.country.toString())
                );
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            closeConnection();
        }
        return publisher;
    }
}
