import java.util.Random;

class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        for (int i = 0; i < name.length(); i++) {
            hash = 31 * hash + name.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return this.id == other.id && this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" + "id=" + id + ", name=" + name + '}';
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + name + '}';
    }
}

public class TestMyHashTable {

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(101); 

        Random random = new Random();

        // Add 10,000 random elements
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Name" + random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id, name);
            Student student = new Student("Student" + i);
            table.put(key, student);
        }

    int[] bucketSizes = table.getBucketSizes();
    for (int i = 0; i < bucketSizes.length; i++) {
        System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
    }
    }
}