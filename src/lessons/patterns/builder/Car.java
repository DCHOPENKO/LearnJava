package lessons.patterns.builder;

public class Car {
    private Transmission transmission;
    private String name;
    private int speed;

    public Car(Transmission transmission, String name, int speed) {
        this.transmission = transmission;
        this.name = name;
        this.speed = speed;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
