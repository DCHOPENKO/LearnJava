package homeworks.basic_tasks.vehicles;


public abstract class Car extends Vehicle{

    Car (Fuel basicFuel) {
        super(4,basicFuel);

        addFuel(new Diesel());

    }

}

