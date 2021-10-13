package homeworks.jdbc;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private int driverId;
    private String firstName;
    private String lastName;
    private int age;
    private Qualification qualification;
    private List<Truck> truckList;

    private Driver() {
        truckList = new ArrayList<>();
    }

    public static DriverBuilder set() {
        return new DriverBuilder();
    }

    public int getDriverId() {
        return driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void addTruckToList(Truck truck) {
        truckList.add(truck);
    }

    @Override
    public String toString() {
        return "Driver{" +
               "driverId=" + driverId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", qualification=" + qualification +
               ", truckList=" + truckList +
               '}';
    }

    public static class DriverBuilder {
        private Driver driver;

        DriverBuilder() {
            driver = new Driver();
        }

        public DriverBuilder setDriverId(int driverId) {
            driver.driverId = driverId;
            return this;
        }

        public DriverBuilder setFirstName(String firstName) {
            driver.firstName = firstName;
            return this;
        }

        public DriverBuilder setLastName(String lastName) {
            driver.lastName = lastName;
            return this;
        }

        public DriverBuilder setAge(int age) {
            driver.age = age;
            return this;
        }

        public DriverBuilder setQualification(Qualification qualification) {
            driver.qualification = qualification;
            return this;
        }

        public Driver build() {
            return driver;
        }

    }
}
