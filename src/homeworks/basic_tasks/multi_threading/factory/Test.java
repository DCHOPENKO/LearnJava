package homeworks.basic_tasks.multi_threading.factory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException, IOException {
        Factory factory = new Factory();

        ProductionLine pen = new ProductionLine("pen", factory);
        ProductionLine fork = new ProductionLine("fork", factory);
        ProductionLine pencil = new ProductionLine("pencil", factory);
        ProductionLine knife = new ProductionLine("knife", factory);
        ProductionLine spoon = new ProductionLine("spoon", factory);

        TimeUnit.SECONDS.sleep(5);
        pen.showStatus();
        spoon.showStatus();

        factory.addWorker("Ivan");

        TimeUnit.SECONDS.sleep(1);
        pen.cancelProduction("need to cancel");
        fork.cancelProduction("sdasd");
        pencil.cancelProduction("sdasd");
        spoon.cancelProduction("sdasd");
        knife.cancelProduction("cancel");
        TimeUnit.SECONDS.sleep(10);
        knife.cancelProduction("cancel2");
        pen.cancelProduction("not correct work");

    }

}
