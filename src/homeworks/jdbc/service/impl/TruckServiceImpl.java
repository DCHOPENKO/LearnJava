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
    private String sql;


    @Override
    public void save(Truck truck) {
        sql = """
                INSERT INTO truck (model, model_Year, FK_driver)
                VALUES
                (?, ?, ?);
                """;

        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getModelYear());
            preparedStatement.setInt(3, truck.getFkDriver());

            printActionResult(preparedStatement.executeUpdate(),
                    "New truck added to DB");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(Truck truck) {
        sql = """
                UPDATE truck
                SET model = ?, model_Year = ?, FK_driver = ?
                WHERE truck_id = ?;
                """;

        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getModelYear());
            preparedStatement.setInt(3, truck.getFkDriver());
            preparedStatement.setInt(4, truck.getTruckId());

            printActionResult(preparedStatement.executeUpdate(),
                    "Existing truck data was updated successfully");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


    @Override
    public void deleteById(int id) {
        sql = """
                DELETE FROM truck
                WHERE truck_id = ?;
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
    public Truck findById(int id) {
        sql = """
                SELECT * FROM truck
                WHERE truck_id = ?;
                """;

        Truck truck = null;
        try (PreparedStatement preparedStatement = ConnectionManager.getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                truck = getTruckFromDB(resultSet);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return truck;
    }

    @Override
    public List<Truck> findAll() {
        List<Truck> trucks = new ArrayList<>();

        sql = "SELECT * FROM truck";

        try (Statement statement = ConnectionManager.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                trucks.add(getTruckFromDB(resultSet));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return trucks;
    }

    private Truck getTruckFromDB(ResultSet resultSet) throws SQLException {
        return Truck.set()
                .setTruckid(resultSet.getInt("truck_id"))
                .setModel(resultSet.getString("model"))
                .setModelYear(resultSet.getInt("model_year"))
                .setFkDriver(resultSet.getInt("FK_driver"))
                .build();
    }
}
