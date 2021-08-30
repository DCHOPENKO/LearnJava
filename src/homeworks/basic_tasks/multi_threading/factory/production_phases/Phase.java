package homeworks.basic_tasks.multi_threading.factory.production_phases;

public abstract class Phase {
    private int producedTime;

    Phase(int producedTime) {
        this.producedTime = producedTime;
    }

    public String getPhaseName () {
        return this.getClass().getSimpleName();
    }

    public int getProducedTime () {
        return producedTime;
    }


}
