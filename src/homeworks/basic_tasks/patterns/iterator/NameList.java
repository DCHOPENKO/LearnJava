package homeworks.basic_tasks.patterns.iterator;

public class NameList {

    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator implements Iterable {
        private int counter;

        Iterator() {
            counter = 0;
        }

        public boolean hasNext() {
            return counter < names.length;
        }

        public String next() {
            return names[counter++];
        }
    }
}
