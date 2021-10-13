package lessons.jdbc;

import java.sql.*;
import java.util.Objects;

public class DbConnector {
    private static Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/sql_lesson?serverTimezone=Europe/Kiev";

    private static Connection getConnection() {
        if (Objects.isNull(connection)) {
            try {
                connection = DriverManager.getConnection(URL, "root", "628325");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }

    public static void showAllPersons() throws SQLException {

        String query = "SELECT * FROM person";

        try (final Statement statement = getConnection().createStatement();
             final ResultSet set = statement.executeQuery(query)) {
            while (set.next()) {
                final int personId = set.getInt("person_id");
                final String firstName = set.getString("first_name");

                System.out.println(personId + "\t" + firstName);
            }
        }
    }

    public static void showAllPersonsPreparedStaement() throws SQLException {

        String query = "SELECT * FROM person WHERE person_id = ? AND first_name = ?;";

        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, 1);
        statement.setString(2, "John");
        final ResultSet set = statement.executeQuery();
        while (set.next()) {
            final int personId = set.getInt("person_id");
            final String firstName = set.getString("first_name");

            System.out.println(personId + "\t" + firstName);
        }
    }

    public static void main(String[] args) throws SQLException {
        showAllPersonsPreparedStaement();
    }

}
