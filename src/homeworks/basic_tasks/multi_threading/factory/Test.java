package homeworks.basic_tasks.multi_threading.factory;

import homeworks.basic_tasks.multi_threading.factory.production_phases.Design;
import homeworks.basic_tasks.multi_threading.factory.production_phases.Develop;
import homeworks.basic_tasks.multi_threading.factory.production_phases.Survey;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        Factory factory = new Factory();

        ProductionLine pen = new ProductionLine("pen", factory)
                .addProductionPhase(new Survey(5))
                .addProductionPhase(new Design(10))
                .addProductionPhase(new Develop(15));

        ProductionLine fork = new ProductionLine("fork", factory)
                .addProductionPhase(new Design(6))
                .addProductionPhase(new Develop(12));
        ProductionLine pencil = new ProductionLine("pencil", factory)
                .addProductionPhase(new Develop(13));
        ProductionLine knife = new ProductionLine("knife", factory)
                .addProductionPhase(new Survey(3))
                .addProductionPhase(new Design(4))
                .addProductionPhase(new Develop(8));
        ProductionLine spoon = new ProductionLine("spoon", factory)
                .addProductionPhase(new Develop(5));

        TimeUnit.SECONDS.sleep(6);
        pen.showStatus();
        spoon.showStatus();

        factory.addWorker("Ivan");

        TimeUnit.SECONDS.sleep(1);
        pen.cancelProduction("need to cancel");
        spoon.cancelProduction("sdasd");
        TimeUnit.SECONDS.sleep(10);
        knife.cancelProduction("cancel2");
        pen.cancelProduction("not correct work");

    }

}
