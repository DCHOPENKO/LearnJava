/*
package homeworks.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsingPool {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/holsteng?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setPassword("123456");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    private List<Man> handleResultSetTest(ResultSet resultSet) throws SQLException {
        List<Man> men = new ArrayList<>();
        while (resultSet.next()) {
            String firstName = resultSet.getString("id");
            String lastName = resultSet.getString("name");
            int countOfChildren = resultSet.getInt("man_age");
            System.out.println(firstName + " " + lastName);
            men.add(new Man(firstName, lastName, countOfChildren));
        }

        return men;
    }

    public List<Man> runSimpleQuery() throws SQLException {
        List<Man> men = null;
        // Statements allow to issue SQL queries to the database
        try (Statement statement = getConnection().createStatement();
             // Result set get the result of the SQL query
             ResultSet resultSet = statement.executeQuery("SELECT * FROM man")) {
            men = handleResultSetTest(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return men;
    }

    public static void main(String[] args) throws SQLException {
        new UsingPool().runSimpleQuery();
    }


}
*/
