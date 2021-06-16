package homeworks.basic_tasks.vehicles;

public class Traffic {

    public static void main(String[] args) throws Exception {

        Vehicle truck = new Truck(8,Fuel.GASOLINE);

        Truck tr = new Truck (16, Fuel.DIESEL);

        Vehicle car = new CompactCar(Fuel.GASOLINE);
        car.upgradeToHybryd();

      car.fuelVehicle(Fuel.ELECTRICITY);
        truck.fuelVehicle(Fuel.GASOLINE);

        tr.fuelVehicle(Fuel.DIESEL);



    }
}
