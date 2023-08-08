import java.util.Arrays;

public class CustomList<T> {

    private Object[] array;
    private int capacity;
    private int size;

    public CustomList() {
        this.size = 0;
        this.capacity = 10;
        array = new Object[10];
    }

    public CustomList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void expand() {
        this.capacity *= 2;
        Object[] expandedArray = new Object[capacity];
        System.arraycopy(array, 0, expandedArray, 0, size);
        array = expandedArray;
    }

    public void add(T element) {
        if(size == capacity -1) {
            expand();
        }
        array[size] = element;
        size++;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "CustomList" +
                "\nArray:" + Arrays.toString(array) +
                "\nCapacity: " + capacity +
                "\nSize: " + size;
    }
}
