package homeworks.imitation_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String INCORRECTINPUT = "Not correct input, please try one more time";
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static boolean sessionFinished = false;
    private static ImitationListService listService = new ImitationListService();

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        System.out.println("Creating new list");
        System.out.println("Input default length for new list");
        listService.createNewList();
        while (!sessionFinished) {
            goToMainMenu();
        }
    }

    public static void goToMainMenu() throws IOException {
        System.out.println("Main menu (choose operation):");
        System.out.println("1. Basic functions (add, delete, change");
        System.out.println("2. Increase/decrease list size");
        System.out.println("3. Print out and sorting");
        System.out.println("4. Additional activities with list");
        System.out.println("5. Exit");
        int inputValue = Integer.parseInt(READER.readLine());
        switch (inputValue) {
            case 1:
                goToChapterOne();
                break;
            case 2:
                goToChapterTwo();
                break;
            case 3:
                goToChapterThree();
                break;
            case 4:
                goToChapterFour();
                break;
            case 5:
                closeAPP();
                break;
            default:
                System.out.println(INCORRECTINPUT);;
                break;
        }
    }

    public static void goToChapterOne() throws IOException {
        System.out.println("Basic functions (add, delete, change:");
        System.out.println("1. Add element");
        System.out.println("2. Remove element");
        System.out.println("3. Change element");
        System.out.println("4. Back to main menu");
        System.out.println("5. Exit");

        int inputValue = Integer.parseInt(READER.readLine());
        switch (inputValue) {
            case 1:
                listService.addElement();
                pressAnyKeyChapterOne();
                break;
            case 2:
                listService.removeElement();
                pressAnyKeyChapterOne();
                break;
            case 3:
                listService.changeElement();
                pressAnyKeyChapterOne();
                break;
            case 4:
                goToMainMenu();
                break;
            case 5:
                closeAPP();
                break;
            default:
                System.out.println(INCORRECTINPUT);
                goToChapterOne();
                break;
        }
    }

    public static void goToChapterTwo() throws IOException {
        System.out.println("Increase/decrease list size");
        System.out.println("1. Increase list size to N elements");
        System.out.println("2. Decrease list size to N elements");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");

        int inputValue = Integer.parseInt(READER.readLine());
        switch (inputValue) {
            case 1:
                listService.increaseArray();
                pressAnyKeyChapterTwo();
                break;
            case 2:
                listService.decreaseArray();
                pressAnyKeyChapterTwo();
                break;
            case 3:
                goToMainMenu();
                break;
            case 4:
                closeAPP();
                break;
            default:
                System.out.println(INCORRECTINPUT);
                goToChapterTwo();
                break;
        }
    }

    public static void goToChapterThree() throws IOException {
        System.out.println("1. Print out array as is");
        System.out.println("2. Print out array in  reverse");
        System.out.println("3. Sorted list using Bubble scenario  then printout result");
        System.out.println("4. Sorted list by Random scenario  then printout result");
        System.out.println("5. Back to main menu");
        System.out.println("6. Exit");

        int inputValue = Integer.parseInt(READER.readLine());
        switch (inputValue) {
            case 1:
                listService.printArray();
                pressAnyKeychapterThree();
                break;
            case 2:
                listService.printArrayReverse();
                pressAnyKeychapterThree();
                break;
            case 3:
                listService.sortArrayByBubble();
                System.out.println("PrintOut result as is");
                listService.printArray();
                pressAnyKeychapterThree();
                break;
            case 4:
                listService.shuffleArrayByRandom();
                System.out.println("PrintOut result as is");
                listService.printArray();
                pressAnyKeychapterThree();
                break;
            case 5:
                goToMainMenu();
                break;
            case 6:
                closeAPP();
                break;
            default:
                System.out.println(INCORRECTINPUT);
                goToChapterThree();
                break;
        }
    }

    public static void goToChapterFour() throws IOException {
        System.out.println("1. Concatenation. Merge 2 arrays to 1");
        System.out.println("2. Delete duplicates");
        System.out.println("3. Finding the index of the first occurrence");
        System.out.println("4. Back to main menu");
        System.out.println("5. Exit");

        int inputValue = Integer.parseInt(READER.readLine());
        switch (inputValue) {
            case 1:
                listService.mergeArrays(listService.createArrayForMerge());
                pressAnyKeyChapterFour();
                break;
            case 2:
                listService.deleteDuplicates();
                pressAnyKeyChapterFour();
                break;
            case 3:
                listService.findIndexOfFirstOccurrence();
                pressAnyKeyChapterFour();
                break;
            case 4:
                goToMainMenu();
                break;
            case 5:
                closeAPP();
                break;
            default:
                System.out.println(INCORRECTINPUT);
                goToChapterFour();
                break;
        }
    }

    private static void pressAnyKeyChapterOne () throws IOException {
        pressAnyKey();
        goToChapterOne();
    }

    private static void pressAnyKeyChapterTwo () throws IOException {
        pressAnyKey();
        goToChapterTwo();
    }

    private static void pressAnyKeychapterThree () throws IOException {
        pressAnyKey();
        goToChapterThree();
    }

    private static void pressAnyKeyChapterFour () throws IOException {
        pressAnyKey();
        goToChapterFour();
    }

    private static void pressAnyKey() throws IOException {
        System.out.println("press Enter to return to previous menu ");
        String text = READER.readLine();
    }

    private static void closeAPP() throws IOException {
        sessionFinished = true;
        READER.close();
        listService.closeScanner();
    }
}

