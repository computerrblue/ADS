public interface MyList<T> {
    void add(T element);          // Add element to the end
    T get(int index);             // Get element at index
    T remove(int index);          // Remove element at index
    int size();                   // Return the number of elements
    boolean isEmpty();            // Check if the list is empty
    void clear();                 // Remove all elements
    boolean contains(T element);  // Check if element exists
    int indexOf(T element);       // Return index of element or -1
    java.util.Iterator<T> iterator(); // Return an iterator
}