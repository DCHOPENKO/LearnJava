package homeworks.basic_tasks.speech;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    private List<Human> persons;

    public HumanService() {
         persons = new ArrayList<>();
    }

    public void addHuman(Human human) {
        persons.add(human);
    }

    public void introduceBrieflyOfEach() {
        for (Human human : persons) {
            human.introduceBriefly();
        }
    }

    public void sayHelloToEach() {
        for (int i = 0; i < persons.size(); i++) {
            for (int j = i + 1; j < persons.size(); j++) {
                Human human1 = persons.get(i);
                Human human2 = persons.get(j);
                human1.sayHello(human2);
                human2.sayHello(human1);
            }
        }
    }
}



