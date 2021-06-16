package homeworks.basic_tasks.vehicles;

public interface Fuelable {
    void fuel();
}

class Gazoline implements Fuelable {
    @Override
    public void fuel() {
        System.out.println("Fuel by gazoline");
    }
}

class Diesel implements Fuelable {
    @Override
    public void fuel() {
        System.out.println("Fuel by diesel");
    }
}
