package homeworks.jdbc.service;

import java.util.List;

public interface CRUDService<T> {
    void save(T t);

    void update(T t);

    void deleteById(int id);

    T findById(int id);

    List<T> findAll();

    default void printActionResult(int rows, String output) {
        if (rows > 0) {
            System.out.println(output);
        } else {
            System.out.println("Whoops, something wrong. System do nothing");
        }
    }
}
