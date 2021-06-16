package homeworks.basic_tasks.recoursion;

public class RecoursionTasks {
    private static int counter = 0;
    private static int result = 1;
//    private static int number = 0;


    public static void main(String[] args) {
       /* System.out.println(IsSequence(new int[]{1, 2, 4, 5, 5, 6, 6, 8}));
        System.out.println(IsSequence(new int[]{14, 3, 4, 5, 5, 6, 6, 7, 6, 7, 6}));
        System.out.println(getMaxValue(187976));
        printResultAboutConsistDigitOne(4359);
        printResultAboutConsistDigitOne(4151);*/

   //     System.out.println(bugger(39, 0));
//        System.out.println(calculateFactorial(5));
//        printBetweenTwoValues(10, 20);
        System.out.println(gcd(36, gcd(24, 12)));
    }

    //a task from image  get qty of multiply times -->  bugger(39) --> 3   3*9 = 27  2*7 = 14  1*4 = 1

    public static int bugger(int sum, int number) {//39
        int result = sum % 10;//9

        if (sum < 10) {
            return number;
        }

        ++number;

        while (sum > 10) {
            sum /= 10;//3
            result *= sum % 10;
        }

        return bugger(result, number);

    }
// 1 2 3 5 8 13
    public static long getFibonachiPosition(int n) {//13
        if (n > 1) {
            return (getFibonachiPosition(n - 2) + getFibonachiPosition(n - 1));
        }
        return n;
// return n > 1 ? getFibonachiPosition(n - 1) + getFibonachiPosition(n - 2) : n;

    }

    public static long calculateFactorial(int n) {//5 = 120
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long result = calculateFactorial(n - 1) * n;
        return result;
    }
    /*
    * 5 = 4! * 5 = 24 * 5 = 120
    * 4 = 3! * 4 = 6 * 4 = 24
    * 3 = 2! * 3 -> 2 * 3 = 6
    * */

    // ?????

    //   b) Дано 4-х значне число (1985) знайти в числі найбільше непарне число вивести його на консоль і
    //   порахувати кількість одиниць в числі.
    //   Якщо в числі немає одиниць то вивести на консоль-"Одиниць немає!!! ".

    private static int getMaxValue(int value) {    // 67794324
        int result = 0;
        if (value != 0) {
            result = Integer.max(value % 10, getMaxValue(value / 10));
        }
        return result;
    }

    private static int countQtyDigitOneInValue(int value) {
        if (value != 0) {
            if (value % 10 == 1) {
                counter++;
            }
            countQtyDigitOneInValue(value / 10);
        }
        return counter;
    }

    private static void printResultAboutConsistDigitOne(int value) {
        int qty = countQtyDigitOneInValue(value);
        if (qty == 0) {
            System.out.println("No any digit 1 in value");
            return;
        }
        System.out.println("Digit 1 have repeated " + qty + " times");
        counter = 0;
    }

    //   c) Дано послідовність.int array={14,3,4,5,5,6,6,7,6,7,6};
    //   Перевірити чи послідовність зростаюча.

    public static boolean IsSequence(int[] array) {
        return IsSequence(array, 0);
    }

    private static boolean IsSequence(int[] array, int index) {
        boolean isTrue = array[index] <= array[index + 1];
        if (index + 2 < array.length && isTrue) {
            isTrue = IsSequence(array, index + 1);
        }
        return isTrue;
    }

    /*public static boolean checkSequenceOnIncreasing() {
        if (countSequence >= array.length - 1) {
            return true;
        }

        if (array[countSequence] > array[++countSequence]) {
            return false;
        }
        return checkSequenceOnIncreasing();
    }*/

    public static void printBetweenTwoValues(int a, int b) {//10, 20
        if (a == b) {
            System.out.print(a + "");
            return;
        }

//        System.out.print(a + "");

        printBetweenTwoValues(++a, b);
        System.out.print(a + "");
    }

    public static long gcd(long a, long b) {//24, 12
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /*
    * 12, 0
    * */

}
