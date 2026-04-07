import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;  // Array to hold elements
    private int size;           // Number of elements in list
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Ensure capacity
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    @Override
    public void add(T element) {

        ensureCapacity();
        elements[size++] = element;
    }
    public void add(int index, T element) {
     if (index < 0 || index > size) throw new IndexOutOfBoundsException();
     ensureCapacity();
     for (int i = size; i > index; i--) {
         elements[i] = elements[i - 1];
    }
     elements[index] = element;
      size++;
}

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (T) elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        T removed = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Help garbage collection
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && element == null) || (elements[i] != null && elements[i].equals(element))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;


            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elements[current++];
            }
        };
    }
}
