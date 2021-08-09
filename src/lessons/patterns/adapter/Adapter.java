package lessons.patterns.adapter;
//Structural patter
public class Adapter extends MiniUSB implements MicroUSB {
    @Override
    public void readMicroUSB() {
        readMiniUSB();
    }

    @Override
    public void writeMicroUSB() {
        writeMiniUSB();
    }
}
