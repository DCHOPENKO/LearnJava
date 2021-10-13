package homeworks.jdbc;

public class Truck {
    private int truckId;
    private String model;
    private int modelYear;
    private int fkDriver;

    private Truck() {
    }

    public static TruckBuilder set() {
        return new TruckBuilder();
    }

    public int getTruckId() {
        return truckId;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getFkDriver() {
        return fkDriver;
    }

    @Override
    public String toString() {
        return "Truck{" +
               "truckId=" + truckId +
               ", model='" + model + '\'' +
               ", modelYear=" + modelYear +
               ", fkDriver=" + fkDriver +
               '}';
    }

    public static class TruckBuilder {
        private Truck truck;

        TruckBuilder() {
            truck = new Truck();
        }

        public TruckBuilder setTruckid(int truckId) {
            truck.truckId = truckId;
            return this;
        }

        public TruckBuilder setModel(String model) {
            truck.model = model;
            return this;
        }

        public TruckBuilder setModelYear(int modelYear) {
            truck.modelYear = modelYear;
            return this;
        }

        public TruckBuilder setFkDriver(int fkDriver) {
            truck.fkDriver = fkDriver;
            return this;
        }

        public Truck build() {
            return truck;
        }

    }
}
