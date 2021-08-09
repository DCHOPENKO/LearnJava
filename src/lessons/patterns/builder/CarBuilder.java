package lessons.patterns.builder;

public class CarBuilder {
    private Transmission transmission;
    private String name;
    private int  speed;

    CarBuilder() {
        transmission = Transmission.MANUAL;
        name = "VAZ";
        speed = 200;
    }

    public CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    public CarBuilder buildSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public Car build() {
        return new Car(transmission, name, speed);
    }
}

class TestBuilder {
    public static void main(String[] args) {
        final Car bmw = new CarBuilder()
                .buildName("Bmw")
                .buildSpeed(300)
                .buildTransmission(Transmission.MANUAL)
                .build();
    }
}
