package homeworks.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_NAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            try {
                connection = DriverManager.getConnection(
                        PropertiesUtil.get(URL_KEY),
                        PropertiesUtil.get(USER_NAME_KEY),
                        PropertiesUtil.get(PASSWORD_KEY)
                );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }
}
