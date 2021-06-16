package homeworks.basic_tasks.speech;

public class Main {

    public static void main(String[] args) {//move to HumanService class
    HumanService community = new HumanService();

    community.addHuman(new Realist());
    community.addHuman(new Formalist());
    community.addHuman(new Neformal());

    community.introduceBrieflyOfEach();

    community.sayHelloToEach();
    }
}
