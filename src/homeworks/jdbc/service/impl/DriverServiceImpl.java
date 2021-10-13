package homeworks.jdbc.service.impl;

import homeworks.jdbc.Driver;
import homeworks.jdbc.Qualification;
import homeworks.jdbc.Truck;
import homeworks.jdbc.service.CRUDService;
import homeworks.jdbc.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DriverServiceImpl implements CRUDService<Driver> {
    private String sql;

    @Override
    public void save(Driver driver) {
        sql = """
                INSERT INTO driver (first_name, last_name, age, qualification)
                VALUES
                (?, ?, ?, ?);
                """;

        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());
            preparedStatement.setString(4, driver.getQualification().getShortName());

            printActionResult(preparedStatement.executeUpdate(),
                    "New driver added to DB");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


    @Override
    public void update(Driver driver) {
        sql = """
                UPDATE driver
                SET first_name = ?, last_name = ?, age = ?, qualification = ?
                WHERE driver_id = ?;
                """;

        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());
            preparedStatement.setString(4, driver.getQualification().getShortName());
            preparedStatement.setInt(5, driver.getDriverId());

            printActionResult(preparedStatement.executeUpdate(),
                    "Existing truck data was updated successfully");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        sql = """
                DELETE FROM driver
                WHERE driver_id = ?;
                """;

        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            printActionResult(preparedStatement.executeUpdate(),
                    "Truck with index " + id + " deleted successfully");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public Driver findById(int id) {

        sql = """
                SELECT * FROM driver d
                INNER JOIN truck t
                ON d.driver_id = t.FK_driver
                WHERE driver_id = ?;
                """;

        Driver driver = null;
        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                driver = getDriverFromDB(resultSet);
            }
            resultSet.beforeFirst();
            while (resultSet.next() && driver != null) {
                driver.addTruckToList(Truck.set()
                        .setTruckid(resultSet.getInt("truck_id"))
                        .setModel(resultSet.getString("model"))
                        .setModelYear(resultSet.getInt("model_year"))
                        .build());
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return driver;
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = new ArrayList<>();
        List<Integer> driverIdList = new ArrayList<>();
        sql = "SELECT * FROM driver;";

        try (Statement statement = ConnectionManager.getConnection().createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                driverIdList.add(resultSet.getInt("driver_id"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        for (Integer id : driverIdList) {
            drivers.add(findById(id));
        }
        return drivers;
    }

    private Qualification getQualificationEnum(String text) {
        Qualification qualification = Qualification.N_A;
        if (text.equals("fresh")) {
            qualification = Qualification.FRESH;
        } else if (text.equals("expert")) {
            qualification = Qualification.EXPERT;
        }
        return qualification;
    }

    private Driver getDriverFromDB(ResultSet resultSet) throws SQLException {
        return Driver.set()
                .setDriverId(resultSet.getInt("driver_id"))
                .setFirstName(resultSet.getString("first_name"))
                .setLastName(resultSet.getString("last_name"))
                .setAge(resultSet.getInt("age"))
                .setQualification(getQualificationEnum(resultSet.getString("qualification")))
                .build();
    }
}
