import homeworks.imitation_list.ImitationList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class ImitatoinListTest {


    private ImitationList list = new ImitationList(4);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private void fillArraySomeData() {
        list.addElement(5);
        list.addElement(8);
        list.addElement(9);
    }

    @Before
    public void clear() {
        list.setArray(new int[4]);
        fillArraySomeData();  // {5, 8, 9}
    }

    @Test
    public void shouldAddElementToArrayWithoutIncreaseArray() {

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{5, 8, 9, 0});
    }

    @Test
    public void shouldNotAddElementToArrayZeroValue() {
        list.addElement(10);
        try {
            list.addElement(0);
            list.addElement(0);
        } catch (ArithmeticException e) {
            int[] array = list.getArray();
            Assert.assertArrayEquals(array, new int[]{5, 8, 9, 10});
        }
    }

    @Test
    public void shouldAddElementToArrayWithIncreaseArray() {
        list.addElement(11);
        list.addElement(15);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{5, 8, 9, 11, 15});
    }

    @Test
    public void shouldRemoveElementFromArray() {

        list.removeElement(1);
        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{5, 9, 0});
    }

    @Test
    public void shouldChangeElementInArrayByIndex() {

        list.changeElementByIndex(1, 123);
        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{5, 123, 9, 0});
    }

    @Test
    public void shouldNotCheckNegativeIndexInArray() {
        try {
            list.changeElementByIndex(-3, 3);
        } catch (NegativeArraySizeException e) {
            int[] array = list.getArray();
            Assert.assertArrayEquals(array, new int[]{5, 8, 9, 0});
        }

    }

    @Test
    public void shouldNotCheckIndexOutOfArrayLength() {
        try {
            list.changeElementByIndex(7, 3);
        } catch (ArrayIndexOutOfBoundsException e) {
            int[] array = list.getArray();
            Assert.assertArrayEquals(array, new int[]{5, 8, 9, 0});
        }

    }

    @Test
    public void shouldIncreaseArrayUpToSomeValue() {
        fillArraySomeData();   // {5, 8, 9}

        list.increaseArray(2);
        int[] array = list.getArray();
        Assert.assertArrayEquals(array, new int[]{5, 8, 9, 0, 0, 0});
    }

    @Test
    public void shouldDecreaseArrayToSetValue() {
        fillArraySomeData();   // {5, 8, 9}

        list.decreaseArray(2);
        int[] array = list.getArray();
        Assert.assertArrayEquals(array, new int[]{5, 8});
    }

    @Test
    public void shouldSortArray() {
        fillArraySomeData();   // {5, 8, 9}

        list.addElement(3);
        list.addElement(6);
        list.sortArrayByBubble();
        int[] array = list.getArray();
        Assert.assertArrayEquals(array, new int[]{3, 5, 6, 8, 9});
    }

    @Test
    public void shouldJoinTwoArraysInOne() {
        fillArraySomeData();   // {5, 8, 9}
        int[] newArray = {22, 21, 23};
        list.joinArray(newArray);
        int[] array = list.getArray();
        Assert.assertArrayEquals(array, new int[]{5, 8, 9, 22, 21, 23});
    }

    @Test
    public void shouldDeleteDuplicatesFromArray() {
        fillArraySomeData();   // {5, 8, 9}
        int[] newArray = {9, 9, 4, 5, 6, 7};
        list.joinArray(newArray);
        list.deleteDuplicates();
        int[] array = list.getArray();
        Assert.assertArrayEquals(array, new int[]{5, 8, 9, 4, 6, 7});
    }

    @Test
    public void shouldFindIndexOfFirstOccurrence() throws IOException {
        fillArraySomeData();   // {5, 8, 9}
        int testResult = list.findIndexOfFirstOccurrence(8);
        Assert.assertEquals(testResult, 1);
    }

    @Test
    public void shouldNotFindIndexOfFirstOccurrence() {
        fillArraySomeData();   // {5, 8, 9}
        try {
            int testResult = list.findIndexOfFirstOccurrence(4);
        } catch (IOException e) {
            Assert.assertEquals(e.getLocalizedMessage(), "No such element in Array");
        }
    }

    @Test(expected = IOException.class)
    public void shouldNotFindIndexOfFirstOccurrence1() throws IOException {

        list.findIndexOfFirstOccurrence(4);

    }

    @Test
    public void shouldNotFindIndexOfFirstOccurrenceWithRule() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("No such element in Array");
        list.findIndexOfFirstOccurrence(4);
    }

    @Test
    public void shouldShuffleArrayByRandom() {
        fillArraySomeData();   // {5, 8, 9}
        list.shuffleArrayByRandom();
        int[] array = list.getArray();
        Assert.assertNotEquals(array, new int[]{5, 8, 9});
    }
}
