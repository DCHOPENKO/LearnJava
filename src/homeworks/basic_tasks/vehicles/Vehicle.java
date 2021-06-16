package homeworks.basic_tasks.vehicles;

import java.util.Objects;

public abstract class Vehicle {
    private int wheels;
    private Fuel basicFuelType;
    private Fuel secondFuelType = Fuel.NOTSET;
    private Fuelable[] fuelables;

    Vehicle(int wheels, Fuel basicFuelType) {
        this.basicFuelType = basicFuelType;
        this.wheels = wheels;
        this.fuelables = new Fuelable[4];//4 nulls
        fuelables[0] = new Gazoline();
        fuelables[1] = new Diesel();
    }

    public void addFuel(Fuelable fuelable) {
        for (int i = 0; i < fuelables.length; i++) {
            if (Objects.isNull(fuelables[i])) {
                fuelables[i] = fuelable;
                break;
            }
        }
    }

    public Vehicle upgradeToHybryd() {
        if (basicFuelType.equals(Fuel.GASOLINE)) {
            secondFuelType = Fuel.ELECTRICITY;
        }
        return this;
    }

    public void fuelVehicle(Fuel fuelType) throws Exception {
        if (basicFuelType.equals(fuelType) || secondFuelType.equals(fuelType)) {
            System.out.println("Vehicle fueled by next fuel - " + fuelType);
        } else {
            throw new Exception("Not correct FuelType, Vehicle crashed");
        }
    }

    public void fuelVehicle1(Fuel fuelType) throws Exception {
        if (!(basicFuelType.equals(fuelType) || secondFuelType.equals(fuelType))) {
            throw new Exception("Not correct FuelType, Vehicle crashed");
        }
        System.out.println("Vehicle fueled by next fuel - " + fuelType);
    }

    abstract void accelerate();

    abstract void brake();
}
