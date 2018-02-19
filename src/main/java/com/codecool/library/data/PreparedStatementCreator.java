package com.codecool.library.data;

import com.codecool.library.utils.QueryLogger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PreparedStatementCreator extends DbHelper {

    public PreparedStatement getPreparedStatementBy(List<Object> args, String sqlStatement) {
        PreparedStatement statement = null;
        try {
            statement = getPreparedStatement(sqlStatement);
            if (!args.isEmpty()) {
                int index = 1;
                for (Object argument : args) {
                    if (argument instanceof String) {
                        String param = (String) argument;
                        statement.setString(index, param);
                    } else if (argument instanceof Integer) {
                        int param = (int) argument;
                        statement.setInt(index, param);
                    } else if (argument instanceof Double) {
                        double param = (double) argument;
                        statement.setDouble(index, param);
                    }
                    index++;
                }
            }
        } catch (SQLException e) {
            QueryLogger.logInfo(e.getClass().getName() + ": " + e.getMessage(), "logs/errors.log");
        }
        return statement;
    }
}
