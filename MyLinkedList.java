import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyLinkedList<T> implements MyList<T>{
    
    private class MyNode{
        T data;
        MyNode next;
        MyNode prev;

        public MyNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
       @Override
    public void add(T element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode node = getNode(index);

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // removing head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // removing tail
        }

        size--;
        return node.data;
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
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if ((current.data == null && element == null) || 
                (current.data != null && current.data.equals(element))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) { // start from head
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else { // start from tail
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
    }
}

    

