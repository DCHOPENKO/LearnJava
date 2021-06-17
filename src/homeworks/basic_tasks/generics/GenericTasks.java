package homeworks.basic_tasks.generics;

public class GenericTasks {

    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{3, 5, 7, 6, 1, 2};
        Double[] arrayDouble = new Double[]{3.3, 5.7, 7.1, 6.6, 1.1, 2.4};

        //a
        System.out.println(ArrayUtil.averageValue(new Array<Integer>(arrayInt)));
        System.out.println(ArrayUtil.averageValue(new Array<Double>(arrayDouble)));

        //b
        System.out.println(MyTestMethod.calcSum(arrayInt, 2));
        System.out.println(MyTestMethod.calcSum(arrayDouble, 5.4));

        //c
        ArrayWorker<Integer> workerArrayInteger = new ArrayWorker<>(arrayInt);
        ArrayWorker<Double> workerArrayDouble = new ArrayWorker<>(arrayDouble);

        System.out.println(workerArrayInteger.calcaulateSum(2));
        System.out.println(workerArrayDouble.calcaulateSum(5.4));
        System.out.println(workerArrayInteger.calcSumSimple(2));
        System.out.println(workerArrayDouble.calcSumSimple(5.4));
    }

    //a task from skype

    public static class Array<T> {
        private T[] array;

        public Array(T[] array) {
            this.array = array;
        }

        public T get(int index) {
            return array[index];
        }

        public int length() {
            return array.length;
        }
    }

    public static class ArrayUtil {

        public static double averageValue(Array<? extends Number> arrayObj) {
            double sumElements = 0;
            for (int i = 0; i < arrayObj.length(); i++) {
                sumElements += arrayObj.get(i).doubleValue();
            }
            return sumElements / arrayObj.length();
        }
    }

    // b) Create class MyTestMethod with generic static method calcNum (with two parameters: an array T[] and
    //variable maxElem of type T) that counts the number of elements in
    //an array T[] that are greater than a specified element maxElem.    4 3 4 2 23 5, 10

    public static class MyTestMethod {

        public static <T extends Number> int calcSum(T[] array, T t) {
            int counter = 0;
            for (T value : array) {
                if (value.doubleValue() > t.doubleValue()) {
                    counter++;
                }
            }
            return counter;
        }
    }

    //c) Create a generic class ArrayWorker with generic array field for working Integer and Double
    //Add code to counts the number of elements in each of arrays that are greater
    //than a specified element.

    public static class ArrayWorker<T extends Number> {
        private T[] array;

        ArrayWorker(T[] array) {
            this.array = array;
        }

        public int calcaulateSum(T t) {
            int sum = 0;
            for (T value : array) {
                if (value.doubleValue() > t.doubleValue()) {
                    sum++;
                }
            }
            return sum;
        }

        public int calcSumSimple(T t) {
            return MyTestMethod.calcSum(array, t);
        }
    }
}
