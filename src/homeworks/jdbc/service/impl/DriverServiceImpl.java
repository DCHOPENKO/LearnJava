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
    private static final String INSERT_QUERY = """
            INSERT INTO driver (first_name, last_name, age, qualification)
            VALUES
            (?, ?, ?, ?);
            """;
    private static final String UPDATE_QUERY = """
            UPDATE driver
            SET first_name = ?, last_name = ?, age = ?, qualification = ?
            WHERE driver_id = ?;
            """;
    private static final String DELETE_QUERY = """
            DELETE FROM driver
            WHERE driver_id = ?;
            """;
    private static final String SELECT_BY_ID_QUERY = """
            SELECT * FROM driver d
            INNER JOIN truck t
            ON d.driver_id = t.FK_driver
            WHERE driver_id = ?;
            """;
    private static final String SELECT_ALL_QUERY = """
            SELECT * FROM driver d
            INNER JOIN truck t
            ON d.driver_id = t.FK_driver
            """;
    private static final String DRIVER_ID_COLUMN_NAME = "driver_id";
    private static final String FIRST_NAME_COLUMN_NAME = "first_name";
    private static final String LAST_NAME_COLUMN_NAME = "last_name";
    private static final String AGE_COLUMN_NAME = "age";
    private static final String QUALIFICATION_COLUMN_NAME = "qualification";
    private static final String TRUCK_ID_COLUMN_NAME = "truck_id";
    private static final String TRUCK_MODEL_COLUMN_NAME = "model";
    private static final String TRUCK_MODEL_YEAR_COLUMN_NAME = "model_year";
    private static final String MESSAGE_SUCCESSFULLY_INSERT = "New driver added to DB";
    private static final String MESSAGE_SUCCESSFULLY_UPDATE = "Existing driver data was updated successfully";
    private static final String MESSAGE_SUCCESSFULLY_DELETE = "Driver deleted successfully with index ";

    @Override
    public void save(Driver driver) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getAge());
        preparedStatement.setString(4, driver.getQualification().getShortName());
        printActionResult(preparedStatement.executeUpdate(), MESSAGE_SUCCESSFULLY_INSERT);
        preparedStatement.close();
    }

    @Override
    public void update(Driver driver) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY);
        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getAge());
        preparedStatement.setString(4, driver.getQualification().getShortName());
        preparedStatement.setInt(5, driver.getDriverId());
        printActionResult(preparedStatement.executeUpdate(), MESSAGE_SUCCESSFULLY_UPDATE);
        preparedStatement.close();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, id);
        printActionResult(preparedStatement.executeUpdate(), MESSAGE_SUCCESSFULLY_DELETE + id);
        preparedStatement.close();
    }

    @Override
    public Driver findById(int id) throws SQLException {
        Driver driver = null;
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(SELECT_BY_ID_QUERY,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            driver = getDriverFromResultSet(resultSet);
        }
        resultSet.beforeFirst();
        while (resultSet.next() && driver != null) {
            driver.addTruckToList(getTruckFromResultSet(resultSet));
        }
        preparedStatement.close();
        return driver;
    }

    @Override
    public List<Driver> findAll() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        List<Integer> drivers_ID = new ArrayList<>();
        Statement statement = ConnectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
        while (resultSet.next()) {
            int currentId = resultSet.getInt(DRIVER_ID_COLUMN_NAME);
            if (drivers_ID.stream().anyMatch(id -> id == currentId)) {
                findTruckBelongToDriver(drivers, resultSet);
                continue;
            }
            drivers_ID.add(currentId);
            drivers.add(getDriverFromResultSet(resultSet));
            findTruckBelongToDriver(drivers, resultSet);
        }
        return drivers;
    }

    private void findTruckBelongToDriver(List<Driver> drivers, ResultSet resultSet) throws SQLException {
        int currentId = resultSet.getInt(DRIVER_ID_COLUMN_NAME);
        Driver driver = drivers.stream().filter(d -> d.getDriverId() == currentId).findFirst().get();
        driver.addTruckToList(getTruckFromResultSet(resultSet));
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

    private Driver getDriverFromResultSet(ResultSet resultSet) throws SQLException {
        return new Driver.DriverBuilder()
                .setDriverId(resultSet.getInt(DRIVER_ID_COLUMN_NAME))
                .setFirstName(resultSet.getString(FIRST_NAME_COLUMN_NAME))
                .setLastName(resultSet.getString(LAST_NAME_COLUMN_NAME))
                .setAge(resultSet.getInt(AGE_COLUMN_NAME))
                .setQualification(getQualificationEnum(resultSet.getString(QUALIFICATION_COLUMN_NAME)))
                .build();
    }

    private Truck getTruckFromResultSet(ResultSet resultSet) throws SQLException {
        return new Truck.TruckBuilder()
                .setTruckid(resultSet.getInt(TRUCK_ID_COLUMN_NAME))
                .setModel(resultSet.getString(TRUCK_MODEL_COLUMN_NAME))
                .setModelYear(resultSet.getInt(TRUCK_MODEL_YEAR_COLUMN_NAME))
                .build();
    }

}
