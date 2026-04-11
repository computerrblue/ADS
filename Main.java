import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Test MyArrayList");
            System.out.println("2. Test MyLinkedList");
            System.out.println("3. Test MyStack");
            System.out.println("4. Test MyQueue");
            System.out.println("5. Test MyMinHeap");
            System.out.println("0. Exit");

            int choice = readInt();

            switch (choice) {
                case 1:
                    testArrayList();
                    break;
                case 2:
                    testLinkedList();
                    break;
                case 3:
                    testStack();
                    break;
                case 4:
                    testQueue();
                    break;
                case 5:
                    testMinHeap();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= SAFE INPUT =================
    private static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // ================= ARRAY LIST =================
    private static void testArrayList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        while (true) {
            System.out.println("\n--- MyArrayList ---");
            System.out.println("1. Add");
            System.out.println("2. Add at index");
            System.out.println("3. Get");
            System.out.println("4. Remove");
            System.out.println("5. Sort");
            System.out.println("6. Print");
            System.out.println("0. Back");

            int c = readInt();

            switch (c) {
                case 1:
                    System.out.print("Enter value: ");
                    list.add(readInt());
                    break;

                case 2:
                    System.out.print("Index: ");
                    int i = readInt();
                    System.out.print("Value: ");
                    list.add(i, readInt());
                    break;

                case 3:
                    System.out.print("Index: ");
                    try {
                        System.out.println("Value: " + list.get(readInt()));
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Index: ");
                    try {
                        list.remove(readInt());
                    } catch (Exception e) {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5:
                    list.sort();
                    System.out.println("Sorted!");
                    break;

                case 6:
                    printList(list);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= LINKED LIST =================
    private static void testLinkedList() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();

        while (true) {
            System.out.println("\n--- MyLinkedList ---");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Print");
            System.out.println("0. Back");

            int c = readInt();

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    list.addFirst(readInt());
                    break;

                case 2:
                    System.out.print("Value: ");
                    list.addLast(readInt());
                    break;

                case 3:
                    if (list.size() == 0) {
                        System.out.println("List is empty!");
                    } else {
                        list.removeFirst();
                    }
                    break;

                case 4:
                    if (list.size() == 0) {
                        System.out.println("List is empty!");
                    } else {
                        list.removeLast();
                    }
                    break;

                case 5:
                    printList(list);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= STACK =================
    private static void testStack() {
        MyStack<Integer> stack = new MyStack<Integer>();

        while (true) {
            System.out.println("\n--- MyStack ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("0. Back");

            int c = readInt();

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    stack.push(readInt());
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Popped: " + stack.pop());
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Top: " + stack.peek());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= QUEUE =================
    private static void testQueue() {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        while (true) {
            System.out.println("\n--- MyQueue ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("0. Back");

            int c = readInt();

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    queue.enqueue(readInt());
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Dequeued: " + queue.dequeue());
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Front: " + queue.peek());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= MIN HEAP =================
    private static void testMinHeap() {
        MyMinHeap<Integer> heap = new MyMinHeap<Integer>();

        while (true) {
            System.out.println("\n--- MyMinHeap ---");
            System.out.println("1. Add");
            System.out.println("2. Remove Min");
            System.out.println("0. Back");

            int c = readInt();

            switch (c) {
                case 1:
                    System.out.print("Value: ");
                    heap.add(readInt());
                    break;

                case 2:
                    try {
                        System.out.println("Min removed: " + heap.removeMin());
                    } catch (Exception e) {
                        System.out.println("Heap is empty!");
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= PRINT =================
    private static void printList(MyList<Integer> list) {
        System.out.print("List: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}