package homeworks.imitation_list;

import java.io.IOException;
import java.util.Random;

public class ImitationList {
    private static final int MIN_INCREMENT = 1;
    private static final Random RANDOM = new Random();
    private int[] array;

    public ImitationList(int size) {
        validateOnlyPositiveValue(size);
        array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private boolean isValue(int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmptyValue() {
        return isValue(0);
    }

    private int getElementIndex(int value) {
        int i = 0;
        while (array[i] != value) {
            i++;
        }
        return i;
    }

    private int getEmptyIndex() {
        return getElementIndex(0);
    }

    public void addElement(int value) {
        if (!validateZeroElement1(value)) {
            System.out.println("");
            return;
        }
        if (!isEmptyValue()) {
            increaseArray(MIN_INCREMENT);
        }
        array[getEmptyIndex()] = value;
    }

    public void removeElement(int index) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);
        int[] arrayFinal = new int[array.length - 1];
        for (int i = 0; i < index; i++) {
            arrayFinal[i] = array[i];
        }
        for (int i = index; i < arrayFinal.length; i++) {
            arrayFinal[i] = array[i + 1];
        }
        array = arrayFinal;
    }

    private int validateIndex (int index) throws ArrayIndexOutOfBoundsException {
        validateOnlyPositiveValue(index);
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return index;
    }

    private int validateZeroElement(int value) throws ArrayIndexOutOfBoundsException {
        if (value == 0) {
            throw new ArithmeticException();
        }
        return value;
    }

    private boolean validateZeroElement1(int value) {

        return value == 0;
    }

    public int validateOnlyPositiveValue(int index) throws ArrayIndexOutOfBoundsException {
        if ( index<0) {
            throw new NegativeArraySizeException();
        }
        return index;
    }

    public void changeElementByIndex(int index, int value) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);
        validateZeroElement(value);
        array[index] = value;
    }

    public void increaseArray(int index) {
        validateOnlyPositiveValue(index);
        int[] tempArray = new int[array.length + index];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
    
    public void decreaseArray(int index) throws ArrayIndexOutOfBoundsException {
        validateIndex(index);
        int[] tempArray = new int[index];
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public void printArray() {
        printArrayByConditions(0, 1);
    }

    public void printArrayInReverse() {
        printArrayByConditions(array.length-1, -1);
    }

    private void printArrayByConditions (int index, int increment) {
        for (int i = 0; i < array.length; i++) {
                System.out.print("[" + array[index] + "] ");
                index+=increment;
            }
            System.out.println();
    }

    public void sortArrayByBubble() {
        int value;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }
            }
        }
    }

    public void joinArray(int[] newArray) {
        if(isEmptyValue()) {
            decreaseArray(getEmptyIndex());
        }
        int length = array.length;
        increaseArray(newArray.length);
        for (int i = 0; i < newArray.length; i++) {
            array[length + i] = newArray[i];
        }
    }

    public void deleteDuplicates() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    removeElement(j);
                    --j;
                }
            }
        }
    }

    public int findIndexOfFirstOccurrence(int value) throws IOException {
        if (!isValue(value)) {
            throw new IOException("No such element in Array");
        }
        return getElementIndex(value);
    }

    public void shuffleArrayByRandom () {
        for (int i = array.length - 1; i > 1; i--) {
            int j = RANDOM.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
  }

}
