package homeworks.jdbc;

import homeworks.jdbc.service.CRUDService;
import homeworks.jdbc.service.impl.DriverServiceImpl;
import homeworks.jdbc.service.impl.TruckServiceImpl;

import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        CRUDService<Driver> driverService = new DriverServiceImpl();
        CRUDService<Truck> truckService = new TruckServiceImpl();

       truckService.save(new Truck.TruckBuilder()
                .setModel("test")
                .setModelYear(2012)
                .setFkDriver(4)
                .build());

        truckService.update(new Truck.TruckBuilder()
                .setTruckid(11)
                .setModel("test2")
                .setModelYear(2012)
                .setFkDriver(1)
                .build());

        var truck = truckService.findById(2);
        System.out.println(truck);

        truckService.deleteById(11);

        var trucks = truckService.findAll();
        trucks.forEach(System.out::println);

        driverService.save(new Driver.DriverBuilder()
                .setFirstName("Test")
                .setLastName("Testov")
                .setAge(44)
                .setQualification(Qualification.FRESH)
                .build());

        driverService.update(new Driver.DriverBuilder()
                .setDriverId(5)
                .setFirstName("Test")
                .setLastName("Testov")
                .setAge(44)
                .setQualification(Qualification.FRESH)
                .build());

        var driver = driverService.findById(1);
        System.out.println(driver);

        driverService.deleteById(5);

        var drivers = driverService.findAll();
        drivers.forEach(System.out::println);
    }
}
