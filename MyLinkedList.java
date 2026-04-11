import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        T data;
        MyNode next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head, tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        MyNode curr = getNode(index);
        MyNode node = new MyNode(item);

        node.prev = curr.prev;
        node.next = curr;
        curr.prev.next = node;
        curr.prev = node;

        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public void set(int index, T item) {
        getNode(index).data = item;
    }

    public void remove(int index) {
        MyNode node = getNode(index);

        if (node == head) {
            removeFirst();
            return;
        }
        if (node == tail) {
            removeLast();
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    public void removeLast() {
        if (tail == null) return;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        MyNode curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr;
    }

    public int indexOf(Object o) {
        MyNode curr = head;
        int i = 0;
        while (curr != null) {
            if (curr.data.equals(o)) return i;
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        MyNode curr = tail;
        int i = size - 1;
        while (curr != null) {
            if (curr.data.equals(o)) return i;
            curr = curr.prev;
            i--;
        }
        return -1;
    }

    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode curr = head;
        int i = 0;
        while (curr != null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    public void sort() {
        // simple bubble sort via swapping node data
        for (int i = 0; i < size; i++) {
            MyNode curr = head;
            while (curr != null && curr.next != null) {
                Comparable a = (Comparable) curr.data;
                Comparable b = (Comparable) curr.next.data;
                if (a.compareTo(b) > 0) {
                    T temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
                curr = curr.next;
            }
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T val = current.data;
                current = current.next;
                return val;
            }
        };
    }
}
