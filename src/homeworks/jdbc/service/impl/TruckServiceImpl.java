package homeworks.jdbc.service.impl;

import homeworks.jdbc.Truck;
import homeworks.jdbc.service.CRUDService;
import homeworks.jdbc.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TruckServiceImpl implements CRUDService<Truck> {
    private static final String INSERT_QUERY = """
            INSERT INTO truck (model, model_Year, FK_driver)
            VALUES
            (?, ?, ?);
            """;
    private static final String UPDATE_QUERY = """
            UPDATE truck
            SET model = ?, model_Year = ?, FK_driver = ?
            WHERE truck_id = ?;
            """;
    private static final String DELETE_QUERY = """
            DELETE FROM truck
            WHERE truck_id = ?;
            """;
    private static final String SELECT_BY_ID_QUERY = """
            SELECT * FROM truck
            WHERE truck_id = ?;
            """;
    private static final String SELECT_ALL_QUERY = """
            SELECT * FROM truck
            """;
    private static final String TRUCK_ID_COLUMN_NAME = "truck_id";
    private static final String MODEL_COLUMN_NAME = "model";
    private static final String MODEL_YEAR_COLUMN_NAME = "model_year";
    private static final String FK_DRIVER_COLUMN_NAME = "FK_driver";
    private static final String MESSAGE_SUCCESSFULLY_INSERT = "New truck added to DB";
    private static final String MESSAGE_SUCCESSFULLY_UPDATE = "Existing truck data was updated successfully";
    private static final String MESSAGE_SUCCESSFULLY_DELETE = "Truck deleted successfully with index ";

    @Override
    public void save(Truck truck) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setString(1, truck.getModel());
        preparedStatement.setInt(2, truck.getModelYear());
        preparedStatement.setInt(3, truck.getFkDriver());
        printActionResult(preparedStatement.executeUpdate(), MESSAGE_SUCCESSFULLY_INSERT);
        preparedStatement.close();
    }

    @Override
    public void update(Truck truck) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY);
        preparedStatement.setString(1, truck.getModel());
        preparedStatement.setInt(2, truck.getModelYear());
        preparedStatement.setInt(3, truck.getFkDriver());
        preparedStatement.setInt(4, truck.getTruckId());
        printActionResult(preparedStatement.executeUpdate(), MESSAGE_SUCCESSFULLY_UPDATE);
        preparedStatement.close();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, id);
        printActionResult(preparedStatement.executeUpdate(),
                MESSAGE_SUCCESSFULLY_DELETE + id);
        preparedStatement.close();
    }

    @Override
    public Truck findById(int id) throws SQLException {
        Truck truck = null;
        PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(SELECT_BY_ID_QUERY);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            truck = getTruckFromResultSet(resultSet);
        }
        preparedStatement.close();
        return truck;
    }

    @Override
    public List<Truck> findAll() throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        Statement statement = ConnectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY);
        while (resultSet.next()) {
            trucks.add(getTruckFromResultSet(resultSet));
        }
        statement.close();
        return trucks;
    }

    private Truck getTruckFromResultSet(ResultSet resultSet) throws SQLException {
        return new Truck.TruckBuilder()
                .setTruckid(resultSet.getInt(TRUCK_ID_COLUMN_NAME))
                .setModel(resultSet.getString(MODEL_COLUMN_NAME))
                .setModelYear(resultSet.getInt(MODEL_YEAR_COLUMN_NAME))
                .setFkDriver(resultSet.getInt(FK_DRIVER_COLUMN_NAME))
                .build();
    }
}
