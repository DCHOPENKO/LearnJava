package homeworks.imitation_list;

import java.io.IOException;
import java.util.Scanner;

public class ImitationListService {
    private static final Scanner READER = new Scanner(System.in);
    private ImitationList list;

    public void createNewList()  {
        int index = READER.nextInt();
        try {
            list = new ImitationList(index);
        }
        catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e ) {
            printNegativeValueExceptionText();
            System.out.println("Input data one more time");
            createNewList();
        }
    }

    private int inputData(String text) {
        System.out.println(text);
        return READER.nextInt();
    }

    public void addElement()  {
        try {
            int value = inputData("Input value to add to list");
            list.addElement(value);
        }
        catch (ArithmeticException e) {
            printZeroValueExceptionText();
        }
    }

    public void removeElement()  {
        try {
            int value = inputData("Input index value to delete element from list");
            list.removeElement(value);
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            printIndexExceptionText();
        }
    }

    public void changeElement()  {
        try {
            int index = inputData("Input index ");
            int value = inputData("Input new value  for next index " + index);
            list.changeElementByIndex(index, value);
        }
        catch (ArithmeticException e) {
            printZeroValueExceptionText();
        }
        catch ( ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            printIndexExceptionText();
        }
    }

    public  void increaseArray() throws IOException {
        try {
            int value = inputData("Input value to increase list");
            list.increaseArray(value);
        }
        catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            printNegativeValueExceptionText();
        }
    }

    public void decreaseArray() throws IOException {
        try {
            int value = inputData("Input value to decrease list");
            list.decreaseArray(value);
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            printIndexExceptionText();
        }
    }

    public void printArray () {
        System.out.println("PrintOut list as is ");
        list.printArray();
    }

    public void printArrayReverse () {
        System.out.println("PrintOut list by reverse ");
        list.printArrayInReverse();
    }

    public void sortArrayByBubble () {
        System.out.println("Sorted list by Bubble scenario");
        list.sortArrayByBubble();
        System.out.println("PrintOut result as is");
        list.printArray();
    }

    public void  shuffleArrayByRandom () {
        System.out.println("Sorted list by Random");
        list.shuffleArrayByRandom();

    }

    public int[] createArrayForMerge() throws IOException {
        System.out.println("Input size for additional array");
        int index = 0;
        try {
            index = READER.nextInt();
            list.validateOnlyPositiveValue(index);
        }
        catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            printNegativeValueExceptionText();
            createArrayForMerge();
        }
        int[] arrayForMerge = new int[index];
        for (int i = 0; i < arrayForMerge.length; i++) {
            try {
                System.out.print("Input value for index № " + (i + 1) + " --> ");
                arrayForMerge[i] = READER.nextInt();
            }
            catch (ArithmeticException e) {
                printZeroValueExceptionText();
                createArrayForMerge();
            }
        }
        return arrayForMerge;
    }

    public void mergeArrays (int[] array) throws IOException {
        System.out.println("Merge 2 arrays and print out result");
        list.joinArray(array);
        list.printArray();
    }

    public void deleteDuplicates() throws IOException {
        System.out.println("Deleted dublicated then printout result");
        list.deleteDuplicates();
        list.printArray();
    }

    public void findIndexOfFirstOccurrence() throws IOException {
        System.out.println("Find Index Of First Occurrence");
        int value = inputData("Input element value for search");
        int index = list.findIndexOfFirstOccurrence(value);
        System.out.println("Index Of First Occurrence for " + value + " is - " + index);
    }

    private void printZeroValueExceptionText() {
        System.out.println(">>> list can not accept value as - 0 <<<");
        System.out.println(">>> Operation canceled <<<");
    }

    private void printNegativeValueExceptionText() {
        System.out.println(">>> Can not accept negative value <<<");
        System.out.println(">>> Operation canceled <<<");
    }

    private void printIndexExceptionText() {
        System.out.println(">>> Index more than array length or negative value <<<");
        System.out.println(">>> Operation canceled <<<");
    }

    public void closeScanner() {
        READER.close();
    }
}
