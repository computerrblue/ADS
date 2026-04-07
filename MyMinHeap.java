public class MyMinHeap<T extends Comparable<T>>{
    private MyArrayList<T> list;
    
    public MyMinHeap(){
        list = new MyArrayList<>();
    
    } 
    public void add(T element) {
        list.add(element);
        heapifyUp(list.size() - 1);
    }

    public T removeMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        T min = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!isEmpty()) {
            list.add(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.remove(i);
        list.add(i, list.get(j));
        list.remove(j + 1);
        list.add(j, temp);
    }
}
