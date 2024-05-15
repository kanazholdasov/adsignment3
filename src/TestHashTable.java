public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i);
            Student value = new Student("Student_" + i);
            table.put(key, value);
        }
        table.printBucketSizes();
    }
}
