package homeworks.basic_tasks.speeddating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isLogIn = true;
    private static Person user;
    private static PersonService service = new PersonService();


    // наполнение условной БД списка людей //

    public static void main(String[] args) throws IOException, InterruptedException {
        openSpeedDatingAPP(service);



  //      while (isLogIn) {
 //           userMenu();
  //      }
    }

    private static int openSpeedDatingAPP(PersonService service) throws IOException, InterruptedException {
        System.out.println("Authorization Form");
        Thread.sleep(2000);
        System.out.println("Please input number for activity: ");
        System.out.println("1 - SIGN IN");
        System.out.println("2 - LOG IN");
        int operationValue = service.inputIntValue();
        if (operationValue == 1) {
            user = service.createNewPerson();
            service.addNewPersonToDB(user);
            service.searchByAge(user);
        } else if (operationValue == 2) {
            throw new IOException("Under construction, use selection 1");
        } else {
            throw new IOException("Incorrect input");
        }
        return operationValue;
    }
/*
    private static void userMenu() throws IOException {

        System.out.println("<<<User Menu>>>");
        System.out.println("1. Search by the opposite sex criteria");
        System.out.println("2. Search by Firstname and Secondname");
        System.out.println("3. Smart search (additional conditions for search)");
        System.out.println("4. Log Out");
        int inputValue = service.inputIntValue();
        switch (inputValue) {
            case 1 -> {
                service.searchBySex(user);
                pressAnyKey();}
            case 2 -> {
                searchByNameSurname();
                pressAnyKey();}
            case 3 -> {
            serchByAdditionalOptions();
            pressAnyKey();}
            case 4 -> {
                isLogIn = false;
                READER.close();
                service.closeScanner();
            }
            default -> throw new IOException("Incorrect input");
        }
    }


 */
    private static void searchByNameSurname() throws IOException {
        System.out.println("Search by Firstname and Secondname");
        System.out.println("Input FirstName");
        String firstName = service.validateText();
        System.out.println("Input SecondName");
        String secondName = service.validateText();
        service.searchByNameAndSurname(firstName, secondName);
    }

    private static void serchByAdditionalOptions() throws IOException {
        System.out.println("Smart search");
        System.out.println("Input city");
        String cityForSearch = service.validateText();
        System.out.println("Input sex (m/f)");
        String sexValueForSearch = service.validateText();
        Sex sexForSearch = PersonService.validateSexInput(sexValueForSearch);
        System.out.print("Input age");
        int ageForSearch = service.inputIntValue();
        System.out.print("Input children q-ty");
        int childrenQtyForSearch = service.inputIntValue();
        service.searchByCustomOptions(cityForSearch, sexForSearch, ageForSearch, childrenQtyForSearch);
    }

    private static void pressAnyKey() throws IOException {
        System.out.println("Press Enter to return to main user menu");
        String text = READER.readLine();
   //     userMenu();
    }



}







