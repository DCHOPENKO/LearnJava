package homeworks.basic_tasks.multi_threading.railway_cashbox;

import java.util.Scanner;

public class TestRailwayCashbox {
    private static final Scanner READER = new Scanner(System.in);
    private static boolean isWork;
    private static RailwayCashbox railway_cashbox;


    public static void main(String[] args) throws InterruptedException {
        startApp();
    }

    private static void generateTickets(RailwayCashbox cashbox) {
        cashbox.addNewTicket(new Ticket("Moscow", "Kiev"));
        cashbox.addNewTicket(new Ticket("Moscow", "Rostov"));
        cashbox.addNewTicket(new Ticket("Moscow", "Tomsk"));
        cashbox.addNewTicket(new Ticket("Tomsk", "Moscow"));
        cashbox.addNewTicket(new Ticket("Kiev", "Moscow"));
        cashbox.addNewTicket(new Ticket("Rostov", "Moscow"));
        cashbox.addNewTicket(new Ticket("Moscow", "Minsk"));
        cashbox.addNewTicket(new Ticket("Minsk", "Moscow"));

    }

    private static void startApp() {
        isWork = true;
        railway_cashbox = new RailwayCashbox();
        generateTickets(railway_cashbox);

        while (isWork) {
            goToMainPage();
        }
    }

    private static void goToMainPage() {
        System.out.println("1. Get user data and executing");
        System.out.println("2. Close App");
        int choice = READER.nextInt();
        switch (choice) {
            case 1:
                getUserData();
                break;
            case 2:
                closeApp();
                break;
            default:
                System.out.println("Incorrect Input");
                goToMainPage();
                break;
        }
    }

    private static void getUserData() {
        System.out.println("Fill userName");
        String name = READER.next();
        System.out.println("What you want toDo (buy, return)");
        String operator = READER.next();
        System.out.println("Fill ticket data: \n Fill Departure City Name");
        String departCityName = READER.next();
        System.out.println("Fill ticket data: \n Fill Arrival City Name");
        String arrivalCityName = READER.next();
        Thread userThread;
        switch (operator) {
            case "buy":
                userThread = (new Thread(new Buyer(name, new Ticket(departCityName, arrivalCityName), railway_cashbox)));
                executeUserRequests(userThread);
                break;
            case "return":
                userThread = (new Thread(new Returner(name, new Ticket(departCityName, arrivalCityName), railway_cashbox)));
                executeUserRequests(userThread);
                break;
            default:
                System.out.println("Incorrect Input");
                getUserData();
                break;

        }

    }

    private static void executeUserRequests(Thread thread) {
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goToMainPage();

    }

    private static void closeApp() {
        READER.close();
        isWork = false;
    }

}
