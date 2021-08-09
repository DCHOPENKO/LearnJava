/*
package lessons.patterns.builder;

*/
/**
 * ПОРОЖДАЮЩИЙ ПАТТЕРН
 * Отделяет конструирование сложного объекта от его представления,
 * так что в результате одного и того же процесса
 * конструирования могут получаться разные представления.
 * - позволяет изменять внутреннее представление продукта;
 * - изолирует код, реализующий конструирование и представление;
 * - дает более тонкий контроль над процессом конструирования.
 *//*


public class Builder {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setCarBuilder(new BMWBuilder());
        Car car = manager.buildCar();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO;
}

class Car {
    private Transmission transmission;
    private String name;
    private int maxSpeed;

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "transmission=" + transmission +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder {
    private Car car;

    protected void createCar() {
        car = new Car();
    }

    abstract void buildName();

    abstract void buildMaxSpeed();

    abstract void buildTransmission();

    public Car getCar() {
        return car;
    }
}

class FordBuilder extends CarBuilder {
    @Override
    void buildName() {
        getCar().setName("Ford");
    }

    @Override
    void buildMaxSpeed() {
        getCar().setMaxSpeed(200);
    }

    @Override
    void buildTransmission() {
        getCar().setTransmission(Transmission.AUTO);
    }
}

class BMWBuilder extends CarBuilder {
    @Override
    void buildName() {
        getCar().setName("BMW");
    }

    @Override
    void buildMaxSpeed() {
        getCar().setMaxSpeed(320);
    }

    @Override
    void buildTransmission() {
        getCar().setTransmission(Transmission.MANUAL);
    }
}


class Manager {
    private CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car buildCar() {
        carBuilder.createCar();
        carBuilder.buildMaxSpeed();
        carBuilder.buildName();
        carBuilder.buildTransmission();
        return carBuilder.getCar();
    }
}*/
