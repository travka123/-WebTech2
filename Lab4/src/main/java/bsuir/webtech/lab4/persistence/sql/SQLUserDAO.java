package bsuir.webtech.lab4.persistence.sql;

import bsuir.webtech.lab4.business.Beans.User;
import bsuir.webtech.lab4.business.UsersRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO extends UsersRepository {

    private final DatabaseController databaseController;

    public SQLUserDAO(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public User getAccountByLogin(String login) {
        User user = null;

        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM USERS WHERE login=?"
            );
            ps.setString(1, login);
            ResultSet result = ps.executeQuery();

            user = getNextUser(result);

        } catch (SQLException ignore) {

        }

        return user;
    }

    private User getNextUser(ResultSet resultSet) throws SQLException {
        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return user;
    }
}
