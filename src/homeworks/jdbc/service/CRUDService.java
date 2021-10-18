package homeworks.jdbc.service;

import java.sql.SQLException;
import java.util.List;

public interface CRUDService<T> {
    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void deleteById(int id) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    default void printActionResult(int rows, String output) {
       /* if (rows > 0) {
            System.out.println(output);
        } else {
            System.out.println("Whoops, something wrong. System do nothing");
        }*/

        System.out.println(rows > 0 ? output : "Whoops, something wrong. System do nothing");
    }
}
